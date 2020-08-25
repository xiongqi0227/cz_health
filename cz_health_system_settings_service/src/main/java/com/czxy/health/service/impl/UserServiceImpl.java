package com.czxy.health.service.impl;

import com.czxy.health.domain.User;
import com.czxy.health.repository.UserRepository;
import com.czxy.health.service.UserService;
import com.czxy.health.utils.BCrypt;
import com.czxy.health.vo.QueryUserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by xiongqi.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public User login(User user) {
        Example example = new Example(User.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("umUsername", user.getUmUsername());
        User u = userRepository.selectOneByExample(example);
        if (u == null) {
            return null;
        }
        //校验密码
        boolean result = BCrypt.checkpw(user.getUmPassword(), u.getUmPassword());
        if (!result){
            return null;
        }
        int num = 1;
        u.setUmLoginTimes(u.getUmLoginTimes()+num);
        userRepository.updateByPrimaryKey(u);
        return u;
    }

    @Override
    public User findUserByPhone(String phone) {
        return userRepository.findUserByPhone(phone);
    }

    @Override
    public int editPassword(User user) {
        user.setEditPassword(BCrypt.hashpw(user.getEditPassword()));
        user.setUmPassword(user.getEditPassword());
        return userRepository.updateByPrimaryKey(user);
    }

    @Override
    public User findAllUserById(Integer mpHealthManager) {
        return userRepository.selectByPrimaryKey(mpHealthManager);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.selectAll();
    }

    @Override
    public User phoneLogin(String phone) {
        User userByPhone = userRepository.findUserByPhone(phone);
        if (userByPhone == null){
            return null;
        }
        userByPhone.setUmLoginTimes(userByPhone.getUmLoginTimes()+1);
        userRepository.updateByPrimaryKey(userByPhone);
        return userByPhone;
    }

    @Override
    public int register(User user) {
        Example example = new Example(User.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("umUsername", user.getUmUsername());
        User u = userRepository.selectOneByExample(example);
        if (u != null) {
            return 0;
        }
        //设置创建时间
        LocalDateTime now = LocalDateTime.now();
        String createTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        user.setUmCreateTime(createTime);
        //密码加密
        String password = BCrypt.hashpw(user.getUmPassword());
        user.setUmPassword(password);
        user.setUmLoginTimes(0);
        userRepository.insert(user);
        return 1;
    }

    @Override
    public PageInfo<User> findUmList(QueryUserVo queryUserVo) {
        PageHelper.startPage(queryUserVo.getPageNum(),queryUserVo.getPageSize());
        if (queryUserVo.getUmUsername()!=null && !"".equals(queryUserVo.getUmUsername())){
            queryUserVo.setUmUsername("%"+queryUserVo.getUmUsername()+"%");
        }
        List<User> list = userRepository.findUmList(queryUserVo);
        return new PageInfo<>(list);
    }

    @Override
    public User findUmById(Integer umId) {
        return userRepository.selectByPrimaryKey(umId);
    }

    @Override
    public int editUm(User user) {
        return userRepository.updateByPrimaryKey(user);
    }

    @Override
    public int deleteUm(Integer umId) {
        return userRepository.deleteByPrimaryKey(umId);
    }
}

package com.czxy.health.service.impl;

import com.czxy.health.domain.MemberProfileDynamicInformation;
import com.czxy.health.domain.MemberProfileEssentialInformation;
import com.czxy.health.domain.MemberProfileMedicalHistory;
import com.czxy.health.domain.User;
import com.czxy.health.feign.MPUFeign;
import com.czxy.health.repository.MPDIrepository;
import com.czxy.health.repository.MPEIRepository;
import com.czxy.health.repository.MPMHRepository;
import com.czxy.health.service.MPEIService;
import com.czxy.health.vo.BaseResult;
import com.czxy.health.vo.MPVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by xiongqi.
 */
@Service
@Transactional
public class MPEIServiceImpl implements MPEIService {
    @Resource
    private MPEIRepository mpeiRepository;
    @Resource
    private MPDIrepository mpdIrepository;
    @Resource
    private MPMHRepository mpmhRepository;
    private static int mpeiId;
    @Resource
    private MPUFeign mpuFeign;
    @Override
    public PageInfo<MemberProfileEssentialInformation> findMPList(MPVo mpVo) {
        PageHelper.startPage(mpVo.getPageNum(), mpVo.getPageSize());
        List<MemberProfileEssentialInformation> list = mpeiRepository.findMPList(mpVo);
        for (MemberProfileEssentialInformation mpei : list) {
            BaseResult<User> allUserById = mpuFeign.findAllUserById(mpei.getMpHealthManager());
            mpei.setUser(allUserById.getData());
        }

        return new PageInfo<>(list);
    }

    @Override
    public int addMpei(MemberProfileEssentialInformation mpei) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mpei.setMpCreateTime(sdf.format(new Date()));
        mpeiRepository.insert(mpei);

        this.mpeiId = mpei.getMpId();
        return mpeiId;
    }

    @Override
    public int addMpDi(MemberProfileDynamicInformation mpdi) {
        mpdi.setMpdiMpId(mpeiId);
        return mpdIrepository.insert(mpdi);
    }

    @Override
    public int addMpMh(MemberProfileMedicalHistory mpmh) {
        System.out.println(mpeiId);
        mpmh.setMpmhMpId(mpeiId);
        return mpmhRepository.insert(mpmh);
    }

    @Override
    public int deleteMp(Integer mpId) {
        int i = mpdIrepository.deleteMpdiById(mpId);
        int y = mpmhRepository.deleteMpmhById(mpId);
        int result = mpeiRepository.deleteByPrimaryKey(mpId);
        if (i == 1 && y == 1 && result == 1) {
            return result;
        }
        return 0;
    }

    @Override
    public MemberProfileEssentialInformation findMpEiById(Integer mpId) {
        return mpeiRepository.selectByPrimaryKey(mpId);
    }

    @Override
    public MemberProfileDynamicInformation findMpDiById(Integer mpId) {
        Example example = new Example(MemberProfileDynamicInformation.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("mpdiMpId", mpId);
        return mpdIrepository.selectOneByExample(example);
    }

    @Override
    public MemberProfileMedicalHistory findMpMhById(Integer mpId) {
        Example example = new Example(MemberProfileMedicalHistory.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("mpmhMpId", mpId);
        return mpmhRepository.selectOneByExample(example);
    }

    @Override
    public int editMpei(MemberProfileEssentialInformation mpei) {
        return mpeiRepository.updateByPrimaryKey(mpei);
    }

    @Override
    public int editMpdi(MemberProfileDynamicInformation mpdi) {
        Example example = new Example(MemberProfileDynamicInformation.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("mpdiMpId",mpdi.getMpdiMpId());
        return mpdIrepository.updateByExample(mpdi,example);
    }

    @Override
    public int editMpmh(MemberProfileMedicalHistory mpmh) {
        Example example = new Example(MemberProfileMedicalHistory.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("mpmhMpId",mpmh.getMpmhMpId());
        return mpmhRepository.updateByExample(mpmh,example);
    }
}

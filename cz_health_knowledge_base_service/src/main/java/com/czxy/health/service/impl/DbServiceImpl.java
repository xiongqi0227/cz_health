package com.czxy.health.service.impl;

import com.czxy.health.domain.DiseaseBank;
import com.czxy.health.repository.DbRepository;
import com.czxy.health.service.DbService;
import com.czxy.health.vo.QueryDb;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiongqi.
 */
@Service
@Transactional
public class DbServiceImpl implements DbService {
    @Resource
    private DbRepository dbRepository;

    @Override
    public PageInfo<DiseaseBank> findDbList(QueryDb queryDb) {
        List<DiseaseBank> l = dbRepository.selectAll();
        for (DiseaseBank db : l) {
            if (db.getDbNumber() == null) {
                db.setDbNumber("db" + db.getDbId());
                dbRepository.updateByPrimaryKey(db);
            }
        }
        PageHelper.startPage(queryDb.getPageNum(), queryDb.getPageSize());
        if (queryDb.getDbName() != null && !"".equals(queryDb.getDbName())) {
            queryDb.setDbName("%" + queryDb.getDbName() + "%");
        }
        List<DiseaseBank> list = dbRepository.findDbList(queryDb);
        return new PageInfo<>(list);
    }

    @Override
    public int addDb(DiseaseBank diseaseBank) {
        return dbRepository.insert(diseaseBank);
    }

    @Override
    public DiseaseBank findDbById(Integer dbId) {
        return dbRepository.selectByPrimaryKey(dbId);
    }

    @Override
    public int editDb(DiseaseBank diseaseBank) {
        return dbRepository.updateByPrimaryKey(diseaseBank);
    }

    @Override
    public int deleteDb(Integer dbId) {
        return dbRepository.deleteByPrimaryKey(dbId);
    }
}

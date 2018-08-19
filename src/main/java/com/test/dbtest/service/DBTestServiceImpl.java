package com.test.dbtest.service;

import com.test.dbtest.dao.domain.DBTest;
import com.test.dbtest.dao.domain.DBTestExample;
import com.test.dbtest.dao.mapper.DBTestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author taoyuanming
 * Created on 2018/8/19
 * Description
 */
@Service
public class DBTestServiceImpl {


    @Resource
    private DBTestMapper dbTestMapper;

    public void insert() {
        DBTest dbTest = new DBTest();
        dbTest.setGmtCreate(new Date());

        dbTestMapper.insertSelective(dbTest);
    }


    public List<DBTest> select(Long id) {
        DBTestExample dbTestExample = new DBTestExample();
        DBTestExample.Criteria criteria = dbTestExample.createCriteria();
        criteria.andIdGreaterThan(id);
        dbTestExample.setOrderByClause(" id asc ");
        return dbTestMapper.selectByExample(dbTestExample);
    }


}

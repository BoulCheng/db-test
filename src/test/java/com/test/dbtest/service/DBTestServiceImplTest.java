package com.test.dbtest.service;

import com.alibaba.fastjson.JSON;
import com.test.dbtest.dao.domain.DBTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author taoyuanming
 * Created on 2018/8/19
 * Description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBTestServiceImplTest {

    @Autowired
    private DBTestServiceImpl dbTestService;

    @Test
    public void insert() {
        dbTestService.insert();
    }

    @Test
    public void select() {
        List<DBTest> dbTests = dbTestService.select(0L);
        System.out.println(JSON.toJSONString(dbTests));
    }

}
package com.test.dbtest.service;

import com.test.dbtest.dao.domain.DBTest;
import com.test.dbtest.thread.InsertRunnable;
import com.test.dbtest.thread.SelectRunnable;
import com.test.dbtest.thread.ThreadPool;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author taoyuanming
 * Created on 2018/8/19
 * Description
 */
@Service
public class RunTest {

    @Bean
    public DBTest dbTest() {
        ThreadPool.execute(new InsertRunnable());
        ThreadPool.execute(new InsertRunnable());
        ThreadPool.execute(new InsertRunnable());
        ThreadPool.execute(new SelectRunnable());
        return new DBTest();
    }
}

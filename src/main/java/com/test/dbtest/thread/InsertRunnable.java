package com.test.dbtest.thread;

import com.test.dbtest.service.DBTestServiceImpl;
import com.test.dbtest.util.BeanUtil;

/**
 * @author taoyuanming
 * Created on 2018/8/19
 * Description
 */
public class InsertRunnable implements Runnable {
    private static DBTestServiceImpl dbTestService = BeanUtil.getBean(DBTestServiceImpl.class);

    @Override
    public void run() {
        while (true) {
            dbTestService.insert();
        }
    }
}

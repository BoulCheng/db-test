package com.test.dbtest.thread;

import com.test.dbtest.dao.domain.DBTest;
import com.test.dbtest.service.DBTestServiceImpl;
import com.test.dbtest.util.BeanUtil;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author taoyuanming
 * Created on 2018/8/19
 * Description
 */
public class SelectRunnable implements Runnable {

    private static DBTestServiceImpl dbTestService = BeanUtil.getBean(DBTestServiceImpl.class);
    private Long id = 0L;

    @Override
    public void run() {
        while (true) {
            List<DBTest> dbTests = dbTestService.select(id);
            if (!CollectionUtils.isEmpty(dbTests)) {
                id = dbTests.get(dbTests.size() - 1).getId();

                for (DBTest dbTest : dbTests) {
                    System.out.println(dbTest.getId());
                }
            }
        }
    }
}

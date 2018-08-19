package com.test.dbtest;

import com.test.dbtest.thread.InsertRunnable;
import com.test.dbtest.thread.SelectRunnable;
import com.test.dbtest.thread.ThreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class DbTestApplication {

    //@PostConstruct
    public void runForcedLiquidation() {
        ThreadFactory nameFactory = new MarginThreadFactory();
        ThreadPoolExecutor singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(16), nameFactory);
        singleThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                ThreadPool.execute(new InsertRunnable());
                ThreadPool.execute(new InsertRunnable());
                ThreadPool.execute(new InsertRunnable());
                ThreadPool.execute(new SelectRunnable());
            }
        });
    }


    static class MarginThreadFactory implements ThreadFactory {
        private static AtomicLong id = new AtomicLong(0);
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "margin-thread-pool-" + id.addAndGet(1));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DbTestApplication.class, args);
    }
}

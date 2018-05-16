package me.study.springboot.async;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.study.springboot.BaseTests;
import me.study.springboot.task.async.pool.PoolTask;


public class PoolAsyncApplicationTests extends BaseTests{

    @Autowired
    private PoolTask task;

    @Test
    public void test() throws Exception {

        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();

        Thread.currentThread().join();
    }

}

package me.study.springboot.async;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.SneakyThrows;
import me.study.springboot.BaseTests;
import me.study.springboot.task.async.pool.RedisTask;


public class RedisAsyncApplicationTests extends BaseTests{

    @Autowired
    private RedisTask task;


    @Test
    @SneakyThrows
    public void test() {

        for (int i = 0; i < 10000; i++) {
            task.doTaskOne(i);
            task.doTaskTwo(i);
            task.doTaskThree(i);

            if (i == 9999) { 
            	System.out.println("********************exit指令已准备发出******************");
                System.exit(0);
               
            }
        }
    }

}

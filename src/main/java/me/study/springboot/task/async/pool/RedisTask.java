package me.study.springboot.task.async.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class RedisTask {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Async("taskExecutor")
    public void doTaskOne(int i) throws Exception {
        log.info("开始做任务一***"+i);
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒***"+i);
    }

    @Async("taskExecutor")
    public void doTaskTwo(int i) throws Exception {
        log.info("开始做任务二***"+i);
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒***"+i);
    }

    @Async("taskExecutor")
    public void doTaskThree(int i) throws Exception {
        log.info("开始做任务三***"+i);
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end - start) + "毫秒***"+i);
    }

}

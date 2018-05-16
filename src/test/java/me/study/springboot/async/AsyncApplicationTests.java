package me.study.springboot.async;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.study.springboot.BaseTests;
import me.study.springboot.task.async.Task;


public class AsyncApplicationTests extends BaseTests{

	@Autowired
	private Task task;

	@Test
	public void test() throws Exception {

		long start = System.currentTimeMillis();

		Future<String> task1 = task.doTaskOne();
		Future<String> task2 = task.doTaskTwo();
		Future<String> task3 = task.doTaskThree();

		while(true) {
			if(task1.isDone() && task2.isDone() && task3.isDone()) {
				// 三个任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}
		System.out.println(task1.get(5, TimeUnit.SECONDS));

		long end = System.currentTimeMillis();

		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

	}

}

package me.study.springboot.rabbit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.study.springboot.BaseTests;

public class RabbitApplicationTests extends BaseTests{

	@Autowired
	private Sender sender;

	@Test
	public void hello() throws Exception {
		sender.send();
	}

}

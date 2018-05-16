package me.study.springboot.jpa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.study.springboot.BaseTests;
import me.study.springboot.domain.jpa.multi.p.JpaUserP;
import me.study.springboot.domain.jpa.multi.p.JpaUserRepositoryP;
import me.study.springboot.domain.jpa.multi.s.Message;
import me.study.springboot.domain.jpa.multi.s.MessageRepository;


public class MultiJpaApplicationTests extends BaseTests{

	@Autowired
	private JpaUserRepositoryP userRepository;
	@Autowired
	private MessageRepository messageRepository;

	@Before
	public void setUp() {
		userRepository.deleteAll();
		messageRepository.deleteAll();
	}

	@Test
	public void test() throws Exception {

		userRepository.save(new JpaUserP("aaa", 10));
		userRepository.save(new JpaUserP("bbb", 20));
		userRepository.save(new JpaUserP("ccc", 30));
		userRepository.save(new JpaUserP("ddd", 40));
		userRepository.save(new JpaUserP("eee", 50));

		Assert.assertEquals(5, userRepository.findAll().size());

		messageRepository.save(new Message("o1", "aaaaaaaaaa"));
		messageRepository.save(new Message("o2", "bbbbbbbbbb"));
		messageRepository.save(new Message("o3", "cccccccccc"));

		Assert.assertEquals(3, messageRepository.findAll().size());

	}


}

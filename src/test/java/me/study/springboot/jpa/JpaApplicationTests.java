package me.study.springboot.jpa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import me.study.springboot.BaseTests;
import me.study.springboot.domain.jpa.JpaUser;
import me.study.springboot.domain.jpa.UserRepository;


public class JpaApplicationTests extends BaseTests{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CacheManager cacheManager;
	
	@Before
	public void before() {
//		userRepository.save(new JpaUser("4AAbbc1", 10));
	}

	@Test
	public void test1() throws Exception {

//		JpaUser u1 = userRepository.findByName("4AAbbc1");
//		System.out.println("第一次查询：" + u1.getAge());
//
//		JpaUser u2 = userRepository.findByName("4AAbbc1");
//		System.out.println("第二次查询：" + u2.getAge());
//
//		u1.setAge(20);
//		userRepository.save(u1);
//		JpaUser u3 = userRepository.findByName("4AAbbc1");
//		System.out.println("第三次查询：" + u3.getAge());

	}

	@Test
	@Transactional
	@Rollback(false)
	public void test() throws Exception {

//		 创建10条记录
		userRepository.save(new JpaUser("AAA", 10));
		userRepository.save(new JpaUser("BBB", 20));
		userRepository.save(new JpaUser("CCC", 30));
		userRepository.save(new JpaUser("DDD", 40));
		userRepository.save(new JpaUser("EEE", 50));
		userRepository.save(new JpaUser("FFF", 60));
		userRepository.save(new JpaUser("GGG", 70));
		userRepository.save(new JpaUser("HHH", 80));
		userRepository.save(new JpaUser("III5555555555", 90));
		userRepository.save(new JpaUser("JJJ", 100));

//		 测试findAll, 查询所有记录
		Assert.assertEquals(10, userRepository.findAll().size());

//		 测试findByName, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

//		 测试findUser, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());

//		 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
		Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

//		 测试删除姓名为AAA的User
		userRepository.delete(userRepository.findByName("AAA"));

//		 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, userRepository.findAll().size());

	}


}

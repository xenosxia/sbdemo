package me.study.springboot.mongo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoClient;

import lombok.extern.slf4j.Slf4j;
import me.study.springboot.BaseTests;
import me.study.springboot.domain.mongo.MongoUser;
import me.study.springboot.domain.mongo.MongoUserRepository;

@Slf4j
public class MongoApplicationTests extends BaseTests {

	@Autowired
	private MongoUserRepository userRepository;

	@Before
	public void setUp() {
		userRepository.deleteAll();
	}

	@Test
	public void test() throws Exception {

		// 创建三个User，并验证User总数
		userRepository.save(new MongoUser(1L, "didi", 30));
		userRepository.save(new MongoUser(2L, "mama", 40));
		userRepository.save(new MongoUser(3L, "kaka", 50));
		Assert.assertEquals(3, userRepository.findAll().size());

		// 删除一个User，再验证User总数
		MongoUser u = userRepository.findOne(1L);
		userRepository.delete(u);
		Assert.assertEquals(2, userRepository.findAll().size());

		// 删除一个User，再验证User总数
		u = userRepository.findByUsername("mama");
		userRepository.delete(u);
		Assert.assertEquals(1, userRepository.findAll().size());

	}

//	 mongoplus测试
	@Autowired
	private MongoClient mongoClient;

	@Test
	public void test1() throws Exception {
		log.info("MinConnectionsPerHost = {}, MaxConnectionsPerHost = {}",
				mongoClient.getMongoClientOptions().getMinConnectionsPerHost(),
				mongoClient.getMongoClientOptions().getConnectionsPerHost());
	}

}

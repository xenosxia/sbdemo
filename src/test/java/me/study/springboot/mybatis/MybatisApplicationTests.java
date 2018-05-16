package me.study.springboot.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import me.study.springboot.BaseTests;
import me.study.springboot.domain.User;
import me.study.springboot.domain.mybatis.MybatisUserMapper;

@Transactional
public class MybatisApplicationTests extends BaseTests{

	@Autowired
	private MybatisUserMapper userMapper;

	@Test
	@Rollback(false)
	public void findByName() throws Exception {
		userMapper.insert("AAAMybatis", 20);
		User u = userMapper.findByName("AAAMybatis");
		System.out.println("****mybatis test" +u.getName());
		Assert.assertEquals(20, u.getAge().intValue());
	}
	
	@Test
	@Rollback(false)
	public void testUserMapper() throws Exception {
		// insert一条数据，并select出来验证
		userMapper.insert("AAA", 20);
		User u = userMapper.findByName("AAA");
		Assert.assertEquals(20, u.getAge().intValue());
		// update一条数据，并select出来验证
		u.setAge(30);
		userMapper.update(u);
		u = userMapper.findByName("AAA");
		Assert.assertEquals(30, u.getAge().intValue());
		// 删除这条数据，并select验证
//		userMapper.delete(u.getId());
//		u = userMapper.findByName("AAA");
//		Assert.assertEquals(null, u);

		u = new User("BBB", 30);
		userMapper.insertByUser(u);
		Assert.assertEquals(30, userMapper.findByName("BBB").getAge().intValue());

		Map<String, Object> map = new HashMap<>();
		map.put("name", "CCC");
		map.put("age", 40);
		userMapper.insertByMap(map);
		Assert.assertEquals(40, userMapper.findByName("CCC").getAge().intValue());

		List<User> userList = userMapper.findAll();
		for(User user : userList) {
			Assert.assertEquals(null, user.getId());
			Assert.assertNotEquals(null, user.getName());
		}

	}

}
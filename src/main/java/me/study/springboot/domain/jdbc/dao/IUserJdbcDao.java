package me.study.springboot.domain.jdbc.dao;

import me.study.springboot.domain.jdbc.JdbcUser;
import me.study.springboot.domain.jdbc.base.Page;

public interface IUserJdbcDao {

	int insert(JdbcUser roncooUser);

	int deleteById(int id);

	int updateById(JdbcUser roncooUser);

	JdbcUser selectById(int id);

	Page<JdbcUser> queryForPage(int i, int j, String string);

}

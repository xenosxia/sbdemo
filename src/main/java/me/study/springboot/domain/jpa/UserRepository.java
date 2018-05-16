package me.study.springboot.domain.jpa;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<JpaUser, Long> {

	@Cacheable(key = "#p0", condition = "#p0.length() < 10")
    JpaUser findByName(String name);
	
    @CachePut(key = "#p0.name")
    JpaUser save(JpaUser user);

    JpaUser findByNameAndAge(String name, Integer age);

    @Query("from JpaUser u where u.name=:name")
    JpaUser findUser(@Param("name") String name);


}

package me.study.springboot.domain.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<MongoUser, Long> {

	MongoUser findByUsername(String username);

}

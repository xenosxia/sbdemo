package me.study.springboot.domain.mongo;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class MongoUser implements Serializable{

	@Id
    private Long id;

    private String username;
    private Integer age;


	public MongoUser(Long id, String username, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
	}
    
    

}

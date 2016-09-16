package com.demo.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.app.model.Demo;

public interface DemoRepository extends MongoRepository<Demo, String> {

}

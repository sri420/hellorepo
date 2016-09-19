package com.demo.app.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.app.model.Demo;

public interface DemoRepository extends MongoRepository<Demo, String> {
	
	public Demo findByStartDateTime(LocalDateTime startDateTime);
	
	public Demo findByDateWithoutTimestamp(LocalDate dateWithoutTimestamp);
	
	public Demo findByDateWithOnlyHour(LocalDateTime dateWithOnlyHour);
	
	public Demo findByDateWithOnlyHourMinute(LocalDateTime dateWithOnlyHourMinute);
	
}

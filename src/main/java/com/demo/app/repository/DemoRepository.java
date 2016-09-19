package com.demo.app.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.app.model.Demo;

public interface DemoRepository extends MongoRepository<Demo, String> {
	
	public List<Demo> findByStartDateTime(LocalDateTime startDateTime);
	
	public List<Demo> findByDateWithoutTimestamp(LocalDate dateWithoutTimestamp);
	
	public List<Demo> findByDateWithOnlyHour(LocalDateTime dateWithOnlyHour);
	
	public List<Demo> findByDateWithOnlyHourMinute(LocalDateTime dateWithOnlyHourMinute);
	
}

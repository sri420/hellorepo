package com.demo.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.demo.app.model.Demo;

@Component
public class DemoTemplateImpl {
	

	@Autowired
	private MongoTemplate mongoTemplate;
	public List<Demo> findDemoBetweenStartDateTimeAndEnddateTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		
		//Construct Query Object from Request object
		Query query=getQueryObjectFromRequest(startDateTime,endDateTime);
		
		
		List<Demo> demoList=mongoTemplate.find(query, Demo.class);
		
		return demoList;
	}

	private Query getQueryObjectFromRequest(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		Query query = new Query(
				Criteria.where("startDateTime").gte(startDateTime).lte(endDateTime)
				);
		return query;
	}

	public List<Demo> findByCustomCriteria(LocalDateTime dateWithOnlyHour, LocalDateTime dateWithOnlyHourMinute) {
		//Construct Query Object from Request object
				Query query=getQueryObjectFromRequestForCustomCriteria(dateWithOnlyHour,dateWithOnlyHourMinute);
				
				
				List<Demo> demoList=mongoTemplate.find(query, Demo.class);
				
				return demoList;
	}

	private Query getQueryObjectFromRequestForCustomCriteria(LocalDateTime dateWithOnlyHour,
			LocalDateTime dateWithOnlyHourMinute) {
		Query query = new Query(
						Criteria.where("dateWithOnlyHour").is(dateWithOnlyHour)
				.andOperator(
						Criteria.where("dateWithOnlyHourMinute").is(dateWithOnlyHourMinute)
						)
				);
		return query;
	}
}

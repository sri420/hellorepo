package com.demo.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.app.helper.DemoHelper;
import com.demo.app.model.Demo;
import com.demo.app.repository.DemoRepository;
import com.demo.app.repository.DemoTemplateImpl;
import com.demo.app.request.DemoRequest;
import com.demo.app.response.DemoResponse;

@Service
public class DemoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoService.class);

	
	@Autowired
	DemoRepository demoRepository;
	
	@Autowired
	DemoTemplateImpl demoTemplateImpl;

	@Autowired
	DemoHelper demoHelper;
	

	
	public Demo saveDemo(DemoRequest demoRequest) {
		LOGGER.info("Entering");

		LocalDateTime startDateTime = demoHelper.getDateTime(demoRequest.getStartDate(), demoRequest.getStartTime());
		LocalDateTime endDateTime = demoHelper.getDateTime(demoRequest.getStartDate(), demoRequest.getEndTime());

		Demo demo = new Demo();
		
		demo.setDemoId(demoRequest.getDemoId());
		demo.setStartDateTime(startDateTime);
		demo.setEndDateTime(endDateTime);
		
		LocalDate dateWithoutTimestamp=demoHelper.getCurrentDateWithoutTimestamp();
		LocalDateTime dateWithOnlyHour=demoHelper.getCurrentDateTimeWithOnlyHour();
		LocalDateTime dateWithOnlyHourMinute=demoHelper.getCurrentDateTimeWithOnlyHourMinute();
				
		
		LOGGER.info("dateWithoutTimestamp:"+ dateWithoutTimestamp);
		LOGGER.info("dateWithOnlyHour:"+ dateWithOnlyHour);
		LOGGER.info("dateWithOnlyHourMinute:"+ dateWithOnlyHourMinute);
		
		demo.setDateWithOnlyHour(dateWithOnlyHour);
		demo.setDateWithOnlyHourMinute(dateWithOnlyHourMinute);
		demo.setDateWithoutTimestamp(dateWithoutTimestamp);
		
		demoRepository.save(demo);
		
		LOGGER.info("Leaving");
		return demoRepository.save(demo);
	}

	public DemoResponse getDemoById(String demoId) throws Exception {
		LOGGER.info("Entering");

		LOGGER.info("Received: demoId:" + demoId);

		DemoResponse demoResponse=null;
		Demo demo = demoRepository.findOne(demoId);

		if (null != demo && demo.getDemoId().trim().length() > 0) {
			demoResponse= demoHelper.getDemoResponse(demo);
			LOGGER.info("Leaving");
			return demoResponse;
		} else {
			LOGGER.error("DemoId not found in the System");
			throw new Exception("DemoId not found in the System");
		}

	}

	public DemoResponse getDemoByStartDateAndTime(LocalDate startDate, LocalTime startTime) throws Exception {
		LOGGER.info("Entering");
		LOGGER.info("Received: startDate:" + startDate);
		LOGGER.info("Received: startTime:" + startTime);
		DemoResponse demoResponse = null;
		Demo demo=demoRepository.findByStartDateTime(demoHelper.getDateTime(startDate, startTime));
		
		if (null != demo && demo.getDemoId().trim().length() > 0) {
			demoResponse= demoHelper.getDemoResponse(demo);
			LOGGER.info("Leaving");
			return demoResponse;
		}else{
			LOGGER.error("Doc not found in the System for startDate and startTime::" + startDate + "::" + startTime);
			throw new Exception("Doc not found in the System for startDate and startTime::" + startDate + "::" + startTime);
		}
	}

	
	

	public DemoResponse getByDateWithoutTimestamp(LocalDate  dateWithoutTimestamp) throws Exception {
		LOGGER.info("Entering");
		LOGGER.info("Received: dateWithoutTimestamp:" + dateWithoutTimestamp);
	
	
		DemoResponse demoResponse = null;
		
		Demo demo=demoRepository.findByDateWithoutTimestamp(dateWithoutTimestamp);
		
		if (null != demo ){
			demoResponse= demoHelper.getDemoResponse(demo);
			LOGGER.info("Leaving");
			return demoResponse;
		}else{
			LOGGER.error("Doc not found in the System for dateWithoutTimestamp::" + dateWithoutTimestamp );
			throw new Exception("Doc not found in the System for dateWithoutTimestamp::" + dateWithoutTimestamp);
		}
	}

	public DemoResponse getByDateWithOnlyHour(LocalDateTime dateWithOnlyHour) throws Exception {
		LOGGER.info("Entering");
		LOGGER.info("Received: dateWithOnlyHour:" + dateWithOnlyHour);
	
	
		DemoResponse demoResponse=null;
		
		Demo demo=demoRepository.findByDateWithOnlyHour(dateWithOnlyHour);
		
		if (null != demo ){
			demoResponse= demoHelper.getDemoResponse(demo);
			return demoResponse;
		}else{
			LOGGER.error("Doc not found in the System for dateWithOnlyHour::" + dateWithOnlyHour );
			throw new Exception("Doc not found in the System for dateWithOnlyHour::" + dateWithOnlyHour);
		}
	}

	public DemoResponse getByDateWithOnlyHourMinute(LocalDateTime dateWithOnlyHourMinute) throws Exception {
		LOGGER.info("Entering");
		LOGGER.info("Received: dateWithOnlyHourMinute:" + dateWithOnlyHourMinute);
	
		DemoResponse demoResponse=null;
		
		Demo demo=demoRepository.findByDateWithOnlyHourMinute(dateWithOnlyHourMinute);
		
		if (null != demo ){
			demoResponse= demoHelper.getDemoResponse(demo);
			return demoResponse;
		}else{
			LOGGER.error("Doc not found in the System for dateWithOnlyHourMinute::" + dateWithOnlyHourMinute );
			throw new Exception("Doc not found in the System for dateWithOnlyHourMinute::" + dateWithOnlyHourMinute);
		}
	}

	public List<DemoResponse> getByCustomCriteria(LocalDateTime dateWithOnlyHour, LocalDateTime dateWithOnlyHourMinute) throws Exception {
		LOGGER.info("Entering");
		LOGGER.info("Received: dateWithOnlyHour:" + dateWithOnlyHour);
		LOGGER.info("Received: dateWithOnlyHourMinute:" + dateWithOnlyHourMinute);
	
		
		
		List<Demo> demoList=demoTemplateImpl.findByCustomCriteria(dateWithOnlyHour,dateWithOnlyHourMinute);
		
		
		if (null != demoList && demoList.size()>0){
			return demoHelper.getDemoResponse(demoList);
		}else{
			LOGGER.error("Doc not found in the System between dateWithOnlyHour and dateWithOnlyHourMinute::" + dateWithOnlyHour + "::" + dateWithOnlyHourMinute);
			throw new Exception("Doc not found in the System for dateWithOnlyHour and dateWithOnlyHourMinute::" + dateWithOnlyHour + "::" + dateWithOnlyHourMinute);
		}
	}

	public List<DemoResponse> getDemoBetweenStartDateTimeAndEndDateTime(LocalDate date, LocalTime startTime, LocalTime endTime) throws Exception {
		LOGGER.info("Entering");
		LOGGER.info("Received: startDate:" + date);
		LOGGER.info("Received: startTime:" + startTime);
		LOGGER.info("Received: endTime:" + endTime);
		
		LocalDateTime startDateTime=demoHelper.getDateTime(date, startTime);
		LocalDateTime endDateTime=demoHelper.getDateTime(date, endTime);
		
		LOGGER.info("Computed: startDateTime:" + startDateTime);
		LOGGER.info("Computed: endDateTime:" + endDateTime);
		
		
		List<Demo> demoList=demoTemplateImpl.findDemoBetweenStartDateTimeAndEnddateTime(startDateTime,endDateTime);
		
		if (null != demoList && demoList.size()>0){
			return demoHelper.getDemoResponse(demoList);
		}else{
			LOGGER.error("Doc not found in the System between startDateTime and endDatetime::" + startDateTime + "::" + endDateTime);
			throw new Exception("Doc not found in the System for startDate and startTime::" + endDateTime + "::" + endDateTime);
		}
	}	
}

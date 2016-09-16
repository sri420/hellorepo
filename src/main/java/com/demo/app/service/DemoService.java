package com.demo.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.app.helper.DemoHelper;
import com.demo.app.model.Demo;
import com.demo.app.repository.DemoRepository;
import com.demo.app.request.DemoRequest;
import com.demo.app.response.DemoResponse;

@Service
public class DemoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoService.class);

	@Autowired
	DemoRepository demoRepository;

	@Autowired
	DemoHelper demoHelper;

	public DemoResponse saveDemo(DemoRequest demoRequest) {
		LOGGER.info("Entering");

		LocalDateTime startDateTime = demoHelper.getDateTime(demoRequest.getStartDate(), demoRequest.getStartTime());
		LocalDateTime endDateTime = demoHelper.getDateTime(demoRequest.getStartDate(), demoRequest.getEndTime());

		Demo demo = new Demo();
		demo.setDemoId(demoRequest.getDemoId());
		demo.setStartDateTime(startDateTime);
		demo.setEndDateTime(endDateTime);

		demoRepository.save(demo);

		demoHelper.displayZonedDateTimes(startDateTime, endDateTime);

		LOGGER.info("Leaving");
		return demoHelper.getDemoResponse(startDateTime, endDateTime);

	}

	public DemoResponse getDemoById(String demoId) throws Exception {
		LOGGER.info("Entering");

		LOGGER.info("Received: demoId:" + demoId);

		Demo demo = demoRepository.findOne(demoId);

		if (null != demo && demo.getDemoId().trim().length() > 0) {
			DemoResponse demoResponse = new DemoResponse();
			demoResponse.setStartDateTime(demo.getStartDateTime());
			demoResponse.setEndDateTime(demo.getEndDateTime());
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
		
		Demo demo=demoRepository.findByStartDateTime(demoHelper.getDateTime(startDate, startTime));
		
		if (null != demo && demo.getDemoId().trim().length() > 0) {
			DemoResponse demoResponse = new DemoResponse();
			demoResponse.setDemoId(demo.getDemoId());
			demoResponse.setStartDateTime(demo.getStartDateTime());
			demoResponse.setEndDateTime(demo.getEndDateTime());
			LOGGER.info("Leaving");
			return demoResponse;
		}else{
			LOGGER.error("Doc not found in the System for startDate and startTime::" + startDate + "::" + startTime);
			throw new Exception("Doc not found in the System for startDate and startTime::" + startDate + "::" + startTime);
		}
	}

	public DemoResponse saveDemoInUTC(DemoRequest demoRequest) {
		LOGGER.info("Entering");
		LOGGER.info("Received: demoRequest:" + demoRequest);

		LocalDateTime startDateTime = demoHelper.getDateTime(demoRequest.getStartDate(), demoRequest.getStartTime());
		LocalDateTime endDateTime = demoHelper.getDateTime(demoRequest.getStartDate(), demoRequest.getEndTime());

		LOGGER.info("startDateTime in LOCAL:" + startDateTime);
		LOGGER.info("endDateTime in LOCAL:" + endDateTime);
		ZonedDateTime zonedDateTimeInUTC=demoHelper.convertDateBetweenTimeZones(startDateTime, "Asia/Calcutta", "UTC");
		
		LOGGER.info("startDateTime in UTC:" + zonedDateTimeInUTC);
		
		Demo demo = new Demo();
		demo.setDemoId(demoRequest.getDemoId());
		demo.setStartDateTime(startDateTime);
		demo.setEndDateTime(endDateTime);
		demo.setNewZonedDateTime(zonedDateTimeInUTC);
		LOGGER.info("demo:" + demo);
		demoRepository.save(demo);

		//demoHelper.displayZonedDateTimes(startDateTime, endDateTime);

		LOGGER.info("Leaving");
		return demoHelper.getDemoResponse(startDateTime, endDateTime);
	}

	public DemoResponse getDemoBetweenStartDateTimeAndEndDateTime(LocalDate date, LocalTime startTime, LocalTime endTime) throws Exception {
		LOGGER.info("Entering");
		LOGGER.info("Received: startDate:" + date);
		LOGGER.info("Received: startTime:" + startTime);
		LOGGER.info("Received: endTime:" + endTime);
		
		LocalDateTime startDateTime=demoHelper.getDateTime(date, startTime);
		LocalDateTime endDateTime=demoHelper.getDateTime(date, startTime);
		
		Demo demo=findDemoBetweenStartDateTimeAndEnddateTime(demoHelper.getDateTime(date, startTime),demoHelper.getDateTime(date, endTime));
		
		if (null != demo && demo.getDemoId().trim().length() > 0) {
			DemoResponse demoResponse = new DemoResponse();
			demoResponse.setDemoId(demo.getDemoId());
			demoResponse.setStartDateTime(demo.getStartDateTime());
			demoResponse.setEndDateTime(demo.getEndDateTime());
			LOGGER.info("Leaving");
			return demoResponse;
		}else{
			LOGGER.error("Doc not found in the System between startDateTime and endDatetime::" + startDateTime + "::" + endDateTime);
			throw new Exception("Doc not found in the System for startDate and startTime::" + endDateTime + "::" + endDateTime);
		}
	}

	private Demo findDemoBetweenStartDateTimeAndEnddateTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {

		
		return null;
	}
}

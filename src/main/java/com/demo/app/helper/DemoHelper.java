package com.demo.app.helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.app.model.Demo;
import com.demo.app.response.DemoResponse;

@Component
public class DemoHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoHelper.class);

	public static final ZoneId AMERICA_ZONE_ID=ZoneId.of("America/Los_Angeles");
	public static final ZoneId UTC_ZONE_ID=ZoneId.of("UTC");
	public static final ZoneId SYSTEM_DEFAULT_ZONE_ID=ZoneId.systemDefault();

	
	public DemoResponse getDemoResponse(Demo demo) {

		LOGGER.info("Entering");
		DemoResponse demoResponse = new DemoResponse();

		demoResponse.setStartDateTime(demo.getStartDateTime());
		demoResponse.setEndDateTime(demo.getEndDateTime());
		
		demoResponse.setZonedStartDateTime(ZonedDateTime.of(demo.getStartDateTime(),SYSTEM_DEFAULT_ZONE_ID));
		demoResponse.setZonedEndDateTime(ZonedDateTime.of(demo.getEndDateTime(),SYSTEM_DEFAULT_ZONE_ID));
		

		demoResponse.setZonedStartDateTimeUSA(convertDateBetweenTimeZones(demo.getStartDateTime(), SYSTEM_DEFAULT_ZONE_ID, AMERICA_ZONE_ID));
		demoResponse.setZonedEndDateTimeUSA(convertDateBetweenTimeZones(demo.getEndDateTime(), SYSTEM_DEFAULT_ZONE_ID, AMERICA_ZONE_ID));
		
		demoResponse.setZonedStartDateTimeUTC(convertDateBetweenTimeZones(demo.getStartDateTime(), SYSTEM_DEFAULT_ZONE_ID, UTC_ZONE_ID));			
		demoResponse.setZonedEndDateTimeUTC(convertDateBetweenTimeZones(demo.getEndDateTime(), SYSTEM_DEFAULT_ZONE_ID, UTC_ZONE_ID));
		
		demoResponse.setDemoId(demo.getDemoId());
		demoResponse.setDateWithOnlyHour(demo.getDateWithOnlyHour());
		
		demoResponse.setDateWithOnlyHourMinute(demo.getDateWithOnlyHourMinute());
		demoResponse.setDateWithoutTimestamp(demo.getDateWithoutTimestamp());
		

		LOGGER.info("Leaving");
		return demoResponse;
	}

	public ZonedDateTime convertDateBetweenTimeZones(LocalDateTime sourceDateTime, ZoneId sourceZoneId,
			ZoneId targetZoneId) {
		return sourceDateTime.atZone(sourceZoneId).withZoneSameInstant(targetZoneId);
	}

	public void displayZonedDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		LOGGER.info("Entering.");

		LOGGER.info("Received...startDateTime:::" + startDateTime);
		LOGGER.info("Received...endDateTime:::" + endDateTime);

		ZonedDateTime zonedStartDateTime = ZonedDateTime.of(startDateTime, ZoneId.systemDefault());
		ZonedDateTime zonedEndDateTime = ZonedDateTime.of(endDateTime, ZoneId.systemDefault());

		LOGGER.info("Computed...zonedStartDateTime:::" + zonedStartDateTime);
		LOGGER.info("Computed...zonedEndDateTime:::" + zonedEndDateTime);

		// Computing date time in different zones(UTC/America_Los_Angeles)

		LOGGER.info("startDateTime in UTC:" + convertDateBetweenTimeZones(startDateTime,ZoneId.of("Asia/Calcutta"), ZoneId.of("UTC")));
		LOGGER.info("endDateTime in UTC:" + convertDateBetweenTimeZones(endDateTime, ZoneId.of("Asia/Calcutta"), ZoneId.of("UTC")));
		LOGGER.info("startDateTime in America/Los_Angeles:"
				+ convertDateBetweenTimeZones(startDateTime, ZoneId.of("Asia/Calcutta"), ZoneId.of("America/Los_Angeles")));
		LOGGER.info("endDateTime in America/Los_Angeles:"
				+ convertDateBetweenTimeZones(endDateTime, ZoneId.of("Asia/Calcutta"), ZoneId.of("America/Los_Angeles")));

		LOGGER.info("Leaving.");
	}

	public LocalDateTime getDateTime(LocalDate startDate, LocalTime startTime) {
		return LocalDateTime.of(startDate, startTime);
	}

	public List<DemoResponse> getDemoResponse(List<Demo> demoList) {
		
		if(null!=demoList && demoList.size() >0){
			List<DemoResponse> newDemoResponseList=new ArrayList<DemoResponse>();
				for(Demo demo:demoList){
					newDemoResponseList.add(getDemoResponse(demo));
				}
				return newDemoResponseList;
		}else{
			return null;
		}
	}

	public LocalDateTime getCurrentDateTimeWithOnlyHour() {
		return getDateTimeWithOnlyHour(LocalDateTime.now());
	}
	
	public LocalDateTime getDateTimeWithOnlyHour(LocalDateTime dateTime) {
		return  LocalDateTime.of(
				dateTime.getYear(),
				dateTime.getMonthValue(),
				dateTime.getDayOfMonth(),
				dateTime.getHour(),
				0,
				0
				);
	}

	public LocalDate getCurrentDateWithoutTimestamp(){
		return LocalDate.now();
	}
	
	
	public LocalDateTime getCurrentDateTimeWithOnlyHourMinute() {
		return geDateTimeWithOnlyHourMinute(LocalDateTime.now());
	}
	
public LocalDateTime geDateTimeWithOnlyHourMinute(LocalDateTime dateTime) {
		
		return LocalDateTime.of(
				dateTime.getYear(),
				dateTime.getMonthValue(),
				dateTime.getDayOfMonth(),
				dateTime.getHour(),
				dateTime.getMinute(),
				0
				);
	}
}

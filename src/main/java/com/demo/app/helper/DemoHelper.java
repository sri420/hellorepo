package com.demo.app.helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.app.response.DemoResponse;

@Component
public class DemoHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoHelper.class);

	public DemoResponse getDemoResponse(LocalDateTime startDateTime, LocalDateTime endDateTime) {

		LOGGER.info("Entering");
		DemoResponse demoResponse = new DemoResponse();

		demoResponse.setStartDateTime(startDateTime);
		demoResponse.setEndDateTime(endDateTime);
		demoResponse.setZonedStartDateTime(ZonedDateTime.of(startDateTime, ZoneId.of("Asia/Calcutta")));
		demoResponse.setZonedEndDateTime(ZonedDateTime.of(endDateTime, ZoneId.of("Asia/Calcutta")));
		demoResponse.setZonedEndDateTimeUTC(convertDateBetweenTimeZones(endDateTime, "Asia/Calcutta", "UTC"));
		demoResponse.setZonedEndDateTimeUSA(
				convertDateBetweenTimeZones(endDateTime, "Asia/Calcutta", "America/Los_Angeles"));

		LOGGER.info("Hur of ZonedStartDateTime: " + demoResponse.getZonedStartDateTime().getHour());
		LOGGER.info("Hour of ZonedEndDateTimeUTC: " + demoResponse.getZonedEndDateTimeUTC().getHour());
		LOGGER.info("Hour of ZonedEndDateTimeUSA: " + demoResponse.getZonedEndDateTimeUSA().getHour());

		LOGGER.info("Leaving");
		return demoResponse;
	}

	private ZonedDateTime convertDateBetweenTimeZones(LocalDateTime sourceDateTime, String sourceZone,
			String targetZone) {
		return sourceDateTime.atZone(ZoneId.of(sourceZone)).withZoneSameInstant(ZoneId.of(targetZone));
	}

	public void displayZonedDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		LOGGER.info("Entering.");

		LOGGER.info("Received...startDateTime:::" + startDateTime);
		LOGGER.info("Received...endDateTime:::" + endDateTime);

		ZonedDateTime zonedStartDateTime = ZonedDateTime.of(startDateTime, ZoneId.of("Asia/Calcutta"));
		ZonedDateTime zonedEndDateTime = ZonedDateTime.of(startDateTime, ZoneId.of("Asia/Calcutta"));

		LOGGER.info("Computed...zonedStartDateTime:::" + zonedStartDateTime);
		LOGGER.info("Computed...zonedEndDateTime:::" + zonedEndDateTime);

		// Computing date time in different zones(UTC/America_Los_Angeles)

		LOGGER.info("startDateTime in UTC:" + convertDateBetweenTimeZones(startDateTime, "Asia/Calcutta", "UTC"));
		LOGGER.info("endDateTime in UTC:" + convertDateBetweenTimeZones(endDateTime, "Asia/Calcutta", "UTC"));
		LOGGER.info("startDateTime in America/Los_Angeles:"
				+ convertDateBetweenTimeZones(startDateTime, "Asia/Calcutta", "America/Los_Angeles"));
		LOGGER.info("endDateTime in America/Los_Angeles:"
				+ convertDateBetweenTimeZones(endDateTime, "Asia/Calcutta", "America/Los_Angeles"));

		LOGGER.info("Leaving.");
	}

	public LocalDateTime getDateTime(LocalDate startDate, LocalTime startTime) {
		return LocalDateTime.of(startDate, startTime);
	}
}

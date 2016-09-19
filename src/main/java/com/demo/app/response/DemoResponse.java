package com.demo.app.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DemoResponse {

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	LocalDateTime startDateTime;

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	LocalDateTime endDateTime;

	@JsonFormat(pattern = "dd::MM::yyyy::HH:mm:z")
	ZonedDateTime zonedStartDateTime;
	
	@JsonFormat(pattern = "dd::MM::yyyy::HH:mm:z")
	ZonedDateTime zonedEndDateTime;

	@JsonFormat(pattern = "dd::MM::yyyy::HH:mm:z")
	ZonedDateTime zonedStartDateTimeUSA;
	
	@JsonFormat(pattern = "dd::MM::yyyy::HH:mm:z")
	ZonedDateTime zonedEndDateTimeUSA;
	
	@JsonFormat(pattern = "dd::MM::yyyy::HH:mm:z")
	ZonedDateTime zonedStartDateTimeUTC;
	
	@JsonFormat(pattern = "dd::MM::yyyy::HH:mm:z")
	ZonedDateTime zonedEndDateTimeUTC;

	
	@JsonFormat(pattern = "dd-MM-yyyy")
	LocalDate dateWithoutTimestamp;
	
	@JsonFormat(pattern = "dd-MM-yyyy::HH")
	LocalDateTime dateWithOnlyHour;
	
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	LocalDateTime dateWithOnlyHourMinute;
	
	

	

	
	public LocalDate getDateWithoutTimestamp() {
		return dateWithoutTimestamp;
	}

	public void setDateWithoutTimestamp(LocalDate dateWithoutTimestamp) {
		this.dateWithoutTimestamp = dateWithoutTimestamp;
	}

	public LocalDateTime getDateWithOnlyHour() {
		return dateWithOnlyHour;
	}

	public void setDateWithOnlyHour(LocalDateTime dateWithOnlyHour) {
		this.dateWithOnlyHour = dateWithOnlyHour;
	}

	public LocalDateTime getDateWithOnlyHourMinute() {
		return dateWithOnlyHourMinute;
	}

	public void setDateWithOnlyHourMinute(LocalDateTime dateWithOnlyHourMinute) {
		this.dateWithOnlyHourMinute = dateWithOnlyHourMinute;
	}

	public ZonedDateTime getZonedStartDateTimeUTC() {
		return zonedStartDateTimeUTC;
	}

	public void setZonedStartDateTimeUTC(ZonedDateTime zonedStartDateTimeUTC) {
		this.zonedStartDateTimeUTC = zonedStartDateTimeUTC;
	}

	public ZonedDateTime getZonedStartDateTimeUSA() {
		return zonedStartDateTimeUSA;
	}

	public ZonedDateTime getZonedEndDateTimeUTC() {
		return zonedEndDateTimeUTC;
	}

	public void setZonedEndDateTimeUTC(ZonedDateTime zonedEndDateTimeUTC) {
		this.zonedEndDateTimeUTC = zonedEndDateTimeUTC;
	}

	public ZonedDateTime getZonedEndDateTimeUSA() {
		return zonedEndDateTimeUSA;
	}

	public void setZonedEndDateTimeUSA(ZonedDateTime zonedEndDateTimeUSA) {
		this.zonedEndDateTimeUSA = zonedEndDateTimeUSA;
	}

	public ZonedDateTime getZonedStartDateTime() {
		return zonedStartDateTime;
	}

	public void setZonedStartDateTime(ZonedDateTime zonedStartDateTime) {
		this.zonedStartDateTime = zonedStartDateTime;
	}

	public ZonedDateTime getZonedEndDateTime() {
		return zonedEndDateTime;
	}

	public void setZonedEndDateTime(ZonedDateTime zonedEndDateTime) {
		this.zonedEndDateTime = zonedEndDateTime;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	@Override
	public String toString() {
		return "DemoResponse [startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", zonedStartDateTime="
				+ zonedStartDateTime + ", zonedEndDateTime=" + zonedEndDateTime + ", zonedStartDateTimeUSA="
				+ zonedStartDateTimeUSA + ", zonedEndDateTimeUSA=" + zonedEndDateTimeUSA + ", zonedStartDateTimeUTC="
				+ zonedStartDateTimeUTC + ", zonedEndDateTimeUTC=" + zonedEndDateTimeUTC + ", dateWithoutTimestamp="
				+ dateWithoutTimestamp + ", dateWithOnlyHour=" + dateWithOnlyHour + ", dateWithOnlyHourMinute="
				+ dateWithOnlyHourMinute + ", demoId=" + demoId + "]";
	}
	
	private String demoId;

	public String getDemoId() {
		return demoId;
	}

	public void setDemoId(String demoId) {
		this.demoId = demoId;
	}

	public void setZonedStartDateTimeUSA(ZonedDateTime zonedStartDateTimeUSA) {
		this.zonedStartDateTimeUSA = zonedStartDateTimeUSA;
	}

	
}

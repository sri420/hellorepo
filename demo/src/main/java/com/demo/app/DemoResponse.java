package com.demo.app;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DemoResponse {

	@JsonFormat(pattern = "dd::MM::yyyy")
	LocalDateTime startDateTime;
	
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm")
	LocalDateTime endDateTime;
	
	@JsonFormat(pattern = "dd::MM::yyyy::HH:mm:z")
	ZonedDateTime zonedStartDateTime;
	@JsonFormat(pattern = "dd::MM::yyyy::HH:mm:z")
	ZonedDateTime zonedEndDateTime;
	
	@JsonFormat(pattern = "dd::MM::yyyy::HH:mm:z")
	ZonedDateTime zonedEndDateTimeUTC;
	
	@JsonFormat(pattern = "dd::MM::yyyy::HH:mm:z")
	ZonedDateTime zonedEndDateTimeUSA;
	
	
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
		return "DemoResponse [startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + "]";
	}
}

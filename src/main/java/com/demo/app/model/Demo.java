package com.demo.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document
@JsonInclude(Include.NON_NULL)
public class Demo {

	@Override
	public String toString() {
		return "Demo [demoId=" + demoId + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime
				+ ", typeName=" + typeName + ", dateWithoutTimestamp=" + dateWithoutTimestamp + ", dateWithOnlyHour="
				+ dateWithOnlyHour + ", dateWithOnlyHourMinute=" + dateWithOnlyHourMinute + ", zonedStartDateTime="
				+ zonedStartDateTime + ", zonedEndDateTime=" + zonedEndDateTime + "]";
	}

	@Id
	String demoId;

	public String getDemoId() {
		return demoId;
	}

	public void setDemoId(String demoId) {
		this.demoId = demoId;
	}
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	LocalDateTime startDateTime;

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
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	LocalDateTime endDateTime;

	String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
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

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss z")
	ZonedDateTime zonedStartDateTime;
	
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss z")
	ZonedDateTime zonedEndDateTime;

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
}

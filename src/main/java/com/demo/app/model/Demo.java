package com.demo.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document
@JsonInclude(Include.NON_NULL)
public class Demo {


	@Id
	String demoId;

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	LocalDateTime startDateTime;

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	LocalDateTime endDateTime;

	
	String typeName;

	@JsonFormat(pattern = "dd-MM-yyyy")
	LocalDate dateWithoutTimestamp;

	@JsonFormat(pattern = "dd-MM-yyyy::HH")
	LocalDateTime dateWithOnlyHour;

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	LocalDateTime dateWithOnlyHourMinute;

	public LocalDateTime getDateWithOnlyHour() {
		return dateWithOnlyHour;
	}

	public LocalDateTime getDateWithOnlyHourMinute() {
		return dateWithOnlyHourMinute;
	}

	public LocalDate getDateWithoutTimestamp() {
		return dateWithoutTimestamp;
	}

	public String getDemoId() {
		return demoId;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setDateWithOnlyHour(LocalDateTime dateWithOnlyHour) {
		this.dateWithOnlyHour = dateWithOnlyHour;
	}

	public void setDateWithOnlyHourMinute(LocalDateTime dateWithOnlyHourMinute) {
		this.dateWithOnlyHourMinute = dateWithOnlyHourMinute;
	}

	public void setDateWithoutTimestamp(LocalDate dateWithoutTimestamp) {
		this.dateWithoutTimestamp = dateWithoutTimestamp;
	}
	
	public void setDemoId(String demoId) {
		this.demoId = demoId;
	}
	
	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@Override
	public String toString() {
		return "Demo [demoId=" + demoId + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime
				+ ", typeName=" + typeName + ", dateWithoutTimestamp=" + dateWithoutTimestamp + ", dateWithOnlyHour="
				+ dateWithOnlyHour + ", dateWithOnlyHourMinute=" + dateWithOnlyHourMinute + "]";
	}

	
	
}

package com.demo.app.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Demo {

	@Override
	public String toString() {
		return "Demo [demoId=" + demoId + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime
				+ ", typeName=" + typeName + ", newZonedDateTime=" + newZonedDateTime + "]";
	}

	@Id
	String demoId;

	public String getDemoId() {
		return demoId;
	}

	public void setDemoId(String demoId) {
		this.demoId = demoId;
	}

	LocalDateTime startDateTime;

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public ZonedDateTime getNewZonedDateTime() {
		return newZonedDateTime;
	}

	public void setNewZonedDateTime(ZonedDateTime newZonedDateTime) {
		this.newZonedDateTime = newZonedDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	LocalDateTime endDateTime;

	String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	ZonedDateTime newZonedDateTime;
}

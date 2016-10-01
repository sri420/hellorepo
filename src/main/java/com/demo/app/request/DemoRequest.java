package com.demo.app.request;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class DemoRequest {
	@NotEmpty
	String demoId;
	
	@NotEmpty
    @Pattern(regexp = "[A-Za-z]+")
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	LocalDate startDate;

	LocalTime startTime;

	LocalTime endTime;

	public String getDemoId() {
		return demoId;
	}

	public LocalTime getEndTime() {
		return endTime;
	}
	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setDemoId(String demoId) {
		this.demoId = demoId;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "DemoRequest [demoId=" + demoId + ", startDate=" + startDate + ", startTime=" + startTime + ", endOTime="
				+ endTime + "]";
	}
	
}

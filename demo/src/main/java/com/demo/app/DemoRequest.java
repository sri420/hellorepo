package com.demo.app;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class DemoRequest {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	LocalDate startDate;
	
	
	@Override
	public String toString() {
		return "DemoRequest [startDate=" + startDate + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	LocalTime startTime;
	LocalTime endTime;
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
}

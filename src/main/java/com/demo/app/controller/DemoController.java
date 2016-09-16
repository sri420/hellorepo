package com.demo.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.model.Demo;
import com.demo.app.request.DemoRequest;
import com.demo.app.response.DemoResponse;
import com.demo.app.service.DemoService;

@RestController
public class DemoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	DemoService demoService;

	@RequestMapping(value = "/demo/{date}/{startTime}/{endTime}", method = RequestMethod.GET)
	public List<Demo> getDemoByStartDate(
			@PathVariable("date")      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
			@PathVariable("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
			@PathVariable("endTime")   @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime) throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...date:::" + date);
		LOGGER.info("Received...startTime:::" + startTime);
		List<Demo> demoResponse = demoService.getDemoBetweenStartDateTimeAndEndDateTime(date, startTime,endTime);
		LOGGER.info("Leaving");
		return demoResponse;
	}

	@RequestMapping(value = "/demo/{id}", method = RequestMethod.GET)
	public DemoResponse getDemo(@PathVariable("id") String id) throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...id:::" + id);

		DemoResponse demoResponse = demoService.getDemoById(id);

		LOGGER.info("Leaving");
		return demoResponse;
	}
	
	
	@RequestMapping(value = "/demo/dateWithoutTimestamp/{date}", method = RequestMethod.GET)
	public Demo getByDateWithoutTimestamp(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...date:::" +date);

		Demo demoResponse = demoService.getByDateWithoutTimestamp(date);

		LOGGER.info("Leaving");
		return demoResponse;
	}

	@RequestMapping(value = "/demo/dateWithOnlyHourMinute/{dateWithOnlyHourMinute}", method = RequestMethod.GET)
	public Demo getByDateWithOnlyHourMinute(@PathVariable("dateWithOnlyHourMinute")  @DateTimeFormat(pattern = "dd-MM-yyyy::HH:mm") LocalDateTime dateWithOnlyHourMinute) throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...dateWithOnlyHourMinute:::" +dateWithOnlyHourMinute);

		Demo demoResponse = demoService.getByDateWithOnlyHourMinute(dateWithOnlyHourMinute);

		LOGGER.info("Leaving");
		return demoResponse;
	}
	
	@RequestMapping(value = "/demo/dateWithOnlyHour/{dateWithOnlyHour}", method = RequestMethod.GET)
	public Demo getBydateWithOnlyHour(@PathVariable("dateWithOnlyHour")  @DateTimeFormat(pattern = "dd-MM-yyyy::HH") LocalDateTime dateWithOnlyHour) throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...dateWithOnlyHour:::" +dateWithOnlyHour);

		Demo demoResponse = demoService.getByDateWithOnlyHour(dateWithOnlyHour);

		LOGGER.info("Leaving");
		return demoResponse;
	}
	
	@RequestMapping(value = "/demo/custom/{dateWithOnlyHour}/{dateWithOnlyHourMinute}", method = RequestMethod.GET)
	public List<Demo> getByCustomCriteria(
			@PathVariable("dateWithOnlyHour")        @DateTimeFormat(pattern = "dd-MM-yyyy::HH")    LocalDateTime dateWithOnlyHour,
			@PathVariable("dateWithOnlyHourMinute")  @DateTimeFormat(pattern = "dd-MM-yyyy::HH:mm") LocalDateTime dateWithOnlyHourMinute
			) throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...dateWithOnlyHour:::" +dateWithOnlyHour);
		LOGGER.info("Received...dateWithOnlyHourMinute:::" +dateWithOnlyHourMinute);
		List<Demo> demoResponse = demoService.getByCustomCriteria(dateWithOnlyHour,dateWithOnlyHourMinute);

		LOGGER.info("Leaving");
		return demoResponse;
	}
	@RequestMapping(value = "/demo", method = RequestMethod.POST)
	public Demo saveDemo(@RequestBody DemoRequest demoRequest) {

		LOGGER.info("Entering...");
		LOGGER.info("Received...demoRequest:::" + demoRequest);

		Demo demoResponse = demoService.saveDemo(demoRequest);

		LOGGER.info("Leaving");

		return demoResponse;
	}
	
	@RequestMapping(value = "/demoutc", method = RequestMethod.POST)
	public DemoResponse saveDemoInUTC(@RequestBody DemoRequest demoRequest) {

		LOGGER.info("Entering...");
		LOGGER.info("Received...demoRequest:::" + demoRequest);

		DemoResponse demoResponse = demoService.saveDemoInUTC(demoRequest);

		LOGGER.info("Leaving");

		return demoResponse;
	}


}

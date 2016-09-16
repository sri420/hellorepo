package com.demo.app.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.request.DemoRequest;
import com.demo.app.response.DemoResponse;
import com.demo.app.service.DemoService;

@RestController
public class DemoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	DemoService demoService;

	@RequestMapping(value = "/demo/{date}/{startTime}/{endTime}", method = RequestMethod.GET)
	public DemoResponse getDemoByStartDate(
			@PathVariable("date")      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
			@PathVariable("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
			@PathVariable("endTime")   @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime) throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...date:::" + date);
		LOGGER.info("Received...startTime:::" + startTime);
		DemoResponse demoResponse = demoService.getDemoBetweenStartDateTimeAndEndDateTime(date, startTime,endTime);
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

	@RequestMapping(value = "/demo", method = RequestMethod.POST)
	public DemoResponse saveDemo(@RequestBody DemoRequest demoRequest) {

		LOGGER.info("Entering...");
		LOGGER.info("Received...demoRequest:::" + demoRequest);

		DemoResponse demoResponse = demoService.saveDemo(demoRequest);

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

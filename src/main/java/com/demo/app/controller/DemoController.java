package com.demo.app.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(value = "/demo/{startDate}/{startTime}", method = RequestMethod.GET)
	public DemoResponse getDemoByStartDate(@PathVariable("startDate") LocalDate startDate,
			@PathVariable("startTime") LocalTime startTime) throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...startDate:::" + startDate);
		LOGGER.info("Received...startTime:::" + startTime);
		DemoResponse demoResponse = demoService.getDemoByStartDateAndTime(startDate, startTime);
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

}

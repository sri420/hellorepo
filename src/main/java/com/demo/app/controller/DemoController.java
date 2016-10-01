package com.demo.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.request.DemoRequest;
import com.demo.app.response.DemoResponse;
import com.demo.app.service.DemoService;
import com.demo.app.validator.CustomValidator;

@RestController
public class DemoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	DemoService demoService;

	@Autowired
	CustomValidator customValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(customValidator);
	}

	@RequestMapping(value = "/demo/{date}/{startTime}/{endTime}", method = RequestMethod.GET)
	public List<DemoResponse> getDemoByStartDate(
			@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
			@PathVariable("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
			@PathVariable("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime)
			throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...date:::" + date);
		LOGGER.info("Received...startTime:::" + startTime);
		List<DemoResponse> demoResponseList = demoService.getDemoBetweenStartDateTimeAndEndDateTime(date, startTime,
				endTime);
		LOGGER.info("Leaving");
		return demoResponseList;
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
	public List<DemoResponse> getByDateWithoutTimestamp(
			@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...date:::" + date);

		List<DemoResponse> demoResponseList = demoService.getByDateWithoutTimestamp(date);

		LOGGER.info("Leaving");
		return demoResponseList;
	}

	@RequestMapping(value = "/demo/dateWithOnlyHourMinute/{dateWithOnlyHourMinute}", method = RequestMethod.GET)
	public List<DemoResponse> getByDateWithOnlyHourMinute(
			@PathVariable("dateWithOnlyHourMinute") @DateTimeFormat(pattern = "dd-MM-yyyy::HH:mm") LocalDateTime dateWithOnlyHourMinute)
			throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...dateWithOnlyHourMinute:::" + dateWithOnlyHourMinute);

		List<DemoResponse> demoResponseList = demoService.getByDateWithOnlyHourMinute(dateWithOnlyHourMinute);

		LOGGER.info("Leaving");
		return demoResponseList;
	}

	@RequestMapping(value = "/demo/dateWithOnlyHour/{dateWithOnlyHour}", method = RequestMethod.GET)
	public List<DemoResponse> getBydateWithOnlyHour(
			@PathVariable("dateWithOnlyHour") @DateTimeFormat(pattern = "dd-MM-yyyy::HH") LocalDateTime dateWithOnlyHour)
			throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...dateWithOnlyHour:::" + dateWithOnlyHour);

		List<DemoResponse> demoResponseList = demoService.getByDateWithOnlyHour(dateWithOnlyHour);

		LOGGER.info("Leaving");
		return demoResponseList;
	}

	@RequestMapping(value = "/demo/custom/{dateWithOnlyHour}/{dateWithOnlyHourMinute}", method = RequestMethod.GET)
	public List<DemoResponse> getByCustomCriteria(
			@PathVariable("dateWithOnlyHour") @DateTimeFormat(pattern = "dd-MM-yyyy::HH") LocalDateTime dateWithOnlyHour,
			@PathVariable("dateWithOnlyHourMinute") @DateTimeFormat(pattern = "dd-MM-yyyy::HH:mm") LocalDateTime dateWithOnlyHourMinute)
			throws Exception {
		LOGGER.info("Entering...");
		LOGGER.info("Received...dateWithOnlyHour:::" + dateWithOnlyHour);
		LOGGER.info("Received...dateWithOnlyHourMinute:::" + dateWithOnlyHourMinute);
		List<DemoResponse> demoResponseList = demoService.getByCustomCriteria(dateWithOnlyHour, dateWithOnlyHourMinute);

		LOGGER.info("Leaving");
		return demoResponseList;
	}

	@RequestMapping(value = "/demo", method = RequestMethod.POST)
	public DemoResponse saveDemo(@RequestBody @Valid DemoRequest demoRequest) throws Exception {

		LOGGER.info("Entering...");
		LOGGER.info("Received...demoRequest:::" + demoRequest);
		// customValidator.validate(demoRequest, bindingResults);
		DemoResponse demoResponse = demoService.saveDemo(demoRequest);

		LOGGER.info("Leaving");

		return demoResponse;
	}

	@RequestMapping(value = "/noreturndemo", method = RequestMethod.POST)
	public void saveNoReturnDemo(@RequestBody DemoRequest demoRequest) {

		LOGGER.info("Entering...");
		LOGGER.info("Received...demoRequest:::" + demoRequest);
		LOGGER.info("Leaving");

	}

}

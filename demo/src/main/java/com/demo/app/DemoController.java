package com.demo.app;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	DemoRepository demoRepository;
	
	 @RequestMapping(value = "/demo", method = RequestMethod.GET)
		public DemoResponse getDemo( DemoFetchRequest demoFetchRequest) throws Exception {
		 Demo demo=demoRepository.findOne(demoFetchRequest.getDemoId());
		 if(null!=demo && demo.getDemoId().trim().length()>0){
		 DemoResponse demoResponse=new DemoResponse();
	     demoResponse.setStartDateTime(demo.getStartDateTime());
	     demoResponse.setEndDateTime(demo.getEndDateTime());
	     return demoResponse;
		 }else{
			 throw new Exception("DemoId not found in the System");
		 }
	 }
	
	 @RequestMapping(value = "/demo/{id}", method = RequestMethod.GET)
		public DemoResponse getDemo(@PathVariable("id") String id) throws Exception {
		 Demo demo=demoRepository.findOne(id);
		 if(null!=demo && demo.getDemoId().trim().length()>0){
		 DemoResponse demoResponse=new DemoResponse();
	     demoResponse.setStartDateTime(demo.getStartDateTime());
	     demoResponse.setEndDateTime(demo.getEndDateTime());
	     return demoResponse;
		 }else{
			 throw new Exception("DemoId not found in the System");
		 }
	 }
	 @RequestMapping(value = "/demo", method = RequestMethod.POST)
		public DemoResponse saveDemo(@RequestBody DemoRequest demoRequest) {
	    	LOGGER.info("Entering...");
	    	LOGGER.info("Received...demoRequest:::" + demoRequest);
	    	LocalDateTime startDateTime=LocalDateTime.of(demoRequest.getStartDate(), demoRequest.getStartTime());
	    	LocalDateTime endDateTime=LocalDateTime.of(demoRequest.getStartDate(), demoRequest.getEndTime());
	    	Demo demo=new Demo();
	    	demo.setDemoId(demoRequest.getDemoId());
	    	demo.setStartDateTime(startDateTime);
	    	demo.setEndDateTime(endDateTime);
	    	demoRepository.save(demo);
	    	DemoResponse demoResponse=new DemoResponse();
	    	demoResponse.setStartDateTime(startDateTime);
	    	demoResponse.setEndDateTime(endDateTime);
	    	demoResponse.setZonedStartDateTime(ZonedDateTime.of(startDateTime, ZoneId.of("Asia/Calcutta")));
	    	demoResponse.setZonedEndDateTime(ZonedDateTime.of(endDateTime, ZoneId.of("Asia/Calcutta")));
	    	demoResponse.setZonedEndDateTimeUTC(convertDateBetweenTimeZones(endDateTime,"Asia/Calcutta","UTC"));
	    	demoResponse.setZonedEndDateTimeUSA(convertDateBetweenTimeZones(endDateTime,"Asia/Calcutta","America/Los_Angeles"));
	    	LOGGER.info("Hur of ZonedStartDateTime: " +demoResponse.getZonedStartDateTime().getHour());
	    	LOGGER.info("Hour of ZonedEndDateTimeUTC: " +demoResponse.getZonedEndDateTimeUTC().getHour());
	    	LOGGER.info("Hour of ZonedEndDateTimeUSA: " +demoResponse.getZonedEndDateTimeUSA().getHour());
	    
	    	//LOGGER.info("Leaving.");
	    	
	    	LOGGER.info("Computed...startDateTime:::" + startDateTime);
	    	LOGGER.info("Computed...endDateTime:::" + endDateTime);
	    	ZonedDateTime zonedStartDateTime=ZonedDateTime.of(startDateTime, ZoneId.of("Asia/Calcutta"));
	    	ZonedDateTime zonedEndDateTime=ZonedDateTime.of(startDateTime, ZoneId.of("Asia/Calcutta"));
	    	LOGGER.info("Computed...zonedStartDateTime:::" + zonedStartDateTime);
	    	LOGGER.info("Computed...zonedEndDateTime:::" + zonedEndDateTime);
	    	LOGGER.info("startDateTime in UTC:" + convertDateBetweenTimeZones(startDateTime,"Asia/Calcutta","UTC"));
	    	LOGGER.info("endDateTime in UTC:" + convertDateBetweenTimeZones(endDateTime,"Asia/Calcutta","UTC"));
	    	LOGGER.info("startDateTime in America/Los_Angeles:" + convertDateBetweenTimeZones(startDateTime,"Asia/Calcutta","America/Los_Angeles"));
	    	LOGGER.info("endDateTime in America/Los_Angeles:" + convertDateBetweenTimeZones(endDateTime,"Asia/Calcutta","America/Los_Angeles"));
	    	return demoResponse;
	    	/**/
	    	
	    }
	 
	 public ZonedDateTime convertDateBetweenTimeZones(LocalDateTime sourceDateTime,String sourceZone,String targetZone){
	     return sourceDateTime.atZone( ZoneId.of(sourceZone)).withZoneSameInstant( ZoneId.of(targetZone));
	    }
	 
	 @RequestMapping(value = "/demo123", method = RequestMethod.POST)
		public void updateSales(@RequestParam("datetime") LocalDate datetime) {
	    	LOGGER.info("Entering...");
	    	LOGGER.info("Received...datetime:::" + datetime);
	    	LOGGER.info("Leaving.");
	    }
	 
	 @RequestMapping(value = "/hello", method = RequestMethod.POST)
		public void sayHello(@RequestParam("datetime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate datetime) {
	    	LOGGER.info("Entering...");
	    	LOGGER.info("Received...datetime:::" + datetime);
	    	LOGGER.info("Leaving.");
	    }
}

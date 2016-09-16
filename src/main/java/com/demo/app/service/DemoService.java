package com.demo.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.app.helper.DemoHelper;
import com.demo.app.model.Demo;
import com.demo.app.repository.DemoRepository;
import com.demo.app.request.DemoRequest;
import com.demo.app.response.DemoResponse;

@Service
public class DemoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoService.class);
	
	@Autowired
	DemoRepository demoRepository;

	@Autowired
	DemoHelper demoHelper;
	
	public DemoResponse saveDemo(DemoRequest demoRequest){
		LOGGER.info("Entering");
		
    	LocalDateTime startDateTime=demoHelper.getDateTime(demoRequest.getStartDate(),demoRequest.getStartTime());
    	LocalDateTime endDateTime=demoHelper.getDateTime(demoRequest.getStartDate(),demoRequest.getEndTime());
    	
    	Demo demo=new Demo();
    	demo.setDemoId(demoRequest.getDemoId());
    	demo.setStartDateTime(startDateTime);
    	demo.setEndDateTime(endDateTime);
    	
    	demoRepository.save(demo);
    	
    	demoHelper.displayZonedDateTimes(startDateTime,endDateTime);
    	
    	LOGGER.info("Leaving");
    	return demoHelper.getDemoResponse(startDateTime,endDateTime);
    	
	}
	

	public DemoResponse getDemoById(String demoId) throws Exception{
		LOGGER.info("Entering");
		
		LOGGER.info("Received: demoId:" + demoId);
		
		Demo demo=demoRepository.findOne(demoId);
		
		if(null!=demo && demo.getDemoId().trim().length()>0){
			 DemoResponse demoResponse=new DemoResponse();
		     demoResponse.setStartDateTime(demo.getStartDateTime());
		     demoResponse.setEndDateTime(demo.getEndDateTime());
		     LOGGER.info("Leaving");
		     return demoResponse;
		}else{
			 LOGGER.error("DemoId not found in the System");
			 throw new Exception("DemoId not found in the System");
		}
		
	}
	
	public DemoResponse getDemoByStartDateAndTime(LocalDate startDate,LocalTime startTime) throws Exception{
		LOGGER.info("Entering");
		
		LOGGER.info("Received: startDate:" + startDate);
		LOGGER.info("Received: startTime:" + startTime);
		
		DemoResponse demoResponse=new DemoResponse();
		
		LOGGER.info("Leaving");
		
		return demoResponse;
	}
	
	
}

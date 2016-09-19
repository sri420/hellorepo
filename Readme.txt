The Purpose of this project is a simple demo of using Java-8 features of
	-LocalDate
	-LocalTime and
	-LocalDateTime
in a Spring Boot Application which exposes an API for Saving Date/Time values and Fetching them based on different criteria.

Spring Data MongoDB has been used to Save and Fetch the values.

The project uses the default MongoDB database which is available on installation.


CREATE a New Demo Document
===========================
HTTP Method :	 POST
API:			/demo
URL:			http://localhost:8080/demo
Payload:
	{
  "startDate":"2016-09-19",
  "startTime":"14:00",
  "endTime":"15:00",
  "demoId":"1"
}


FETCH an Existing Document by Id
================================
HTTP Method :	 GET
API:			/demo/{id}
URL:			http://localhost:8080/demo/1



FETCH an Existing Document based on the "dateWithoutTimestamp" field in the document
====================================================================================
HTTP Method :	 GET
API:			/demo/dateWithoutTimestamp/{dateWithoutTimestamp}
URL:			http://localhost:8080/demo/dateWithoutTimestamp/2016-09-19


FETCH an Existing Document based on the "dateWithOnlyHourMinute" field in the document
====================================================================================
HTTP Method :	 GET
API:			/demo/dateWithOnlyHourMinute/{dateWithOnlyHourMinute}
URL:			http://localhost:8080/demo/dateWithOnlyHourMinute/19-09-2016::15:08


FETCH an Existing Document based on the "dateWithOnlyHour" field in the document
====================================================================================
HTTP Method :	 GET
API:			/demo/dateWithOnlyHour/{dateWithOnlyHour}
URL:			http://localhost:8080/demo/dateWithOnlyHour/19-09-2016::15

FETCH an Existing Document based on the "dateWithOnlyHour" field in the document
====================================================================================
HTTP Method :	 GET
API:			/custom/{dateWithOnlyHour}/{dateWithOnlyHourAndMinute}
URL:			http://localhost:8080/demo/custom/19-09-2016::15/19-09-2016::15:08


FETCH an Existing Document based on the "date" ,"startTime" and "endTime"
=========================================================================
HTTP Method :	 GET
API:			/custom/{dateWithoutTimestamp}/{startTime}/{endTime}
URL:			http://localhost:8080/demo/2016-09-19/14:00/15:00








 


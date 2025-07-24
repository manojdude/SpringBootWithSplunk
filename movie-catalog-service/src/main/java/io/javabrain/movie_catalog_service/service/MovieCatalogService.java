package io.javabrain.movie_catalog_service.service;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MovieCatalogService {

	Logger logger = LogManager.getLogger(MovieCatalogService.class);

	public void Hello() {
		logger.info("MovieCatalogService : Hello Method is started");
		System.out.println("Hello Manoj");
		System.out.println("Logger class = " + logger.getClass());
		logger.info("MovieCatalogService : Hello Method is Ended");
		logger.info("🚀 Splunk test message at {}", LocalDateTime.now());
	}

//	public void sendTestToSplunk() {
//		System.out.println("in sendTestToSplunk");
//	    HttpEventCollectorSender sender = new HttpEventCollectorSender(
//	        "http://localhost:8088",
//	        "b1d2a7dc-2b96-4c3b-b1e7-7e765db667e4",
//	        "movie-catalog-service",
//	        "logback",
//	        "movie-catalog-dev",
//	        true, false, null, null, null
//	    );
//
//	    sender.send("java-splunk-test", new HashMap<>(), "🧪 Hello from Splunk Java SDK", null);
//	    sender.flush();
//	}
}

package com.demo.roadmap;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.roadmap.service.impl.RoadMapCacheHandler;

@SpringBootApplication
public class RoadmapApplication {
	private static final Logger logger = LoggerFactory.getLogger("RoadMapApplication.class");
	
	@Autowired RoadMapCacheHandler roadMapCacheHandler;

	public static void main(String[] args) {
		SpringApplication.run(RoadmapApplication.class, args);
	}
	
	@PostConstruct
	private void init() throws Exception {
		logger.info("Initializing the RoadMapApplication !!!");
		roadMapCacheHandler.initialize("src/main/resources/city.txt");
	}
}

package com.demo.roadmap.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.roadmap.controllers.RoadMapController;
import com.demo.roadmap.model.RoadMapCache;
import com.demo.roadmap.service.IRoadMapService;
import com.demo.roadmap.service.impl.RoadMapCacheHandler;
import com.demo.roadmap.service.impl.RoadMapService;

@Configuration
public class RoadMapConfiguration {
	
	/*
	@Bean
	public RoadMapCache roadMapCache() {
		return new RoadMapCache();
	}

	@Bean
	public RoadMapCacheHandler roadMapCacheHandler() {
		return new RoadMapCacheHandler();
	}

	@Bean
	public IRoadMapService roadMapService() {
		return new RoadMapService(roadMapCacheHandler());
	}

	@Bean
	public RoadMapController roadMapCongtroller() {
		return new RoadMapController(roadMapService());
	}
	*/
}

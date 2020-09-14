package com.demo.roadmap.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.roadmap.constant.CityConnectEnum;
import com.demo.roadmap.model.City;
import com.demo.roadmap.model.RoadMapResponse;
import com.demo.roadmap.service.IRoadMapService;

@Service
public class RoadMapService implements IRoadMapService {
	private static final Logger logger = LoggerFactory.getLogger("RoadMapService.class");
	
	private RoadMapCacheHandler roadMapCacheHandler;
	
	@Autowired
	public RoadMapService(RoadMapCacheHandler roadMapCacheHandler) {
		this.roadMapCacheHandler = roadMapCacheHandler;
	}

	@Override
	public RoadMapResponse checkConnectivity(String origin, String destination) {
		logger.debug("Verifying connectivity between {} and {}", origin, destination);
		
		boolean areConnected = roadMapCacheHandler.areConnected(City.builder().name(origin).build()
																, City.builder().name(destination).build());
		return RoadMapResponse.builder()
								.connected(areConnected? CityConnectEnum.CONNECTED.getStatus(): CityConnectEnum.NOT_CONNECTED.getStatus())
								.origin(origin)
								.destination(destination)
								.build();
	}


	public void setRoadMapCacheHandler(RoadMapCacheHandler roadMapCacheHandler) {
		this.roadMapCacheHandler = roadMapCacheHandler;
	}
}

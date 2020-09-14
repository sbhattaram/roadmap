package com.demo.roadmap.service;

import com.demo.roadmap.model.RoadMapResponse;

public interface IRoadMapService {
	public RoadMapResponse checkConnectivity(String origin, String destination);
}
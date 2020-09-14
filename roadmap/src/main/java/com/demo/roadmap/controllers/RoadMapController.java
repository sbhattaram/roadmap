package com.demo.roadmap.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.roadmap.model.RoadMapRequest;
import com.demo.roadmap.model.RoadMapResponse;
import com.demo.roadmap.service.IRoadMapService;

@RestController
public class RoadMapController {
	private static final Logger logger = LoggerFactory.getLogger("RoadMappController.class");

	private IRoadMapService roadMapService;
	
	@Autowired
	public RoadMapController(IRoadMapService roadMapService) {
		this.roadMapService = roadMapService;
	}

	@GetMapping("/connected")
	public ResponseEntity<RoadMapResponse> getConnected(@RequestParam String origin, @RequestParam String destination) {
		//... This log statement might give low vulnerability.
		//... This can be avoided either by having a OWASP validator.
		logger.debug("Received request to check connection between [{},{}]", origin, destination);

		RoadMapResponse roadMapResponse = roadMapService.checkConnectivity(origin, destination);

		return ResponseEntity.status(HttpStatus.OK)
								.body(roadMapResponse);
	}


	@PostMapping("/connected")
	public ResponseEntity<RoadMapResponse> getConnected(@RequestBody RoadMapRequest roadMapRequest) {
		//... This log statement might give low vulnerability.
		//... This can be avoided either by having a OWASP validator.
		logger.debug("Received request to check connection between [{},{}]", roadMapRequest.getOrigin(), roadMapRequest.getDestination());

		RoadMapResponse roadMapResponse = roadMapService.checkConnectivity(roadMapRequest.getOrigin(), roadMapRequest.getDestination());

		return ResponseEntity.status(HttpStatus.OK)
								.body(roadMapResponse);
	}
}

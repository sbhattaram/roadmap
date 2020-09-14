package com.demo.roadmap.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.roadmap.constant.CityConnectEnum;
import com.demo.roadmap.model.RoadMapResponse;


@SpringBootTest
class RoadMapServiceTest {
	@Autowired RoadMapCacheHandler roadMapCacheHandler;
	@Autowired private RoadMapService roadMapService;
	
	private static final String filename = "src/main/resources/city.txt";
	private static final String ORIGIN = "Boston";
	private static final String DESTINATION = "New York";

	private static final String DESTINATION2 = "Bridgewater";

	@Before
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Mockito.reset(roadMapService);
		roadMapCacheHandler.initialize(filename);
		roadMapService.setRoadMapCacheHandler(roadMapCacheHandler);
	}

	@Test
	void testCheckConnectivityYes() {
		RoadMapResponse checkConnectivity = roadMapService.checkConnectivity(ORIGIN, DESTINATION);
		assertEquals(ORIGIN, checkConnectivity.getOrigin());
		assertEquals(DESTINATION, checkConnectivity.getDestination());
		assertEquals(CityConnectEnum.CONNECTED.getStatus(), checkConnectivity.getConnected());
	}
	
	@Test
	void testCheckConnectivityNo() {
		RoadMapResponse checkConnectivity = roadMapService.checkConnectivity(ORIGIN, DESTINATION2);
		assertEquals(ORIGIN, checkConnectivity.getOrigin());
		assertEquals(DESTINATION2, checkConnectivity.getDestination());
		assertEquals(CityConnectEnum.NOT_CONNECTED.getStatus(), checkConnectivity.getConnected());
	}
}

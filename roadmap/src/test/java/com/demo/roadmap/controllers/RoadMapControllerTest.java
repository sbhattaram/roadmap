package com.demo.roadmap.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.roadmap.constant.CityConnectEnum;
import com.demo.roadmap.model.RoadMapResponse;
import com.demo.roadmap.service.impl.RoadMapService;

@SpringBootTest
class RoadMapControllerTest {

	@Mock RoadMapService roadMapService;
	@InjectMocks RoadMapController roadMapController; 
	
	private RoadMapResponse roadMapResponse;
	private static final String ORIGIN = "Boston";
	private static final String DESTINATION = "New York";

	private void setupData() {
		roadMapResponse = RoadMapResponse.builder().connected(CityConnectEnum.CONNECTED.getStatus())
													.origin(ORIGIN)
													.destination(DESTINATION)
													.build();
	}

	@Before
	public void setUp() throws Exception {
		setupData();
		MockitoAnnotations.initMocks(this);
		Mockito.reset(roadMapService);
	}

	@Test
	public void testGetConnectedStringString() throws Exception {
		when(roadMapService.checkConnectivity(Matchers.anyString(), Matchers.anyString()))
							.thenReturn(roadMapResponse);
		roadMapController.getConnected(ORIGIN, DESTINATION);
		verify(roadMapService, times(1)).checkConnectivity(Matchers.anyString(), Matchers.anyString());
	}
}

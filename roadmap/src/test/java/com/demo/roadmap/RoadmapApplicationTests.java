package com.demo.roadmap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.roadmap.controllers.RoadMapController;

@SpringBootTest
class RoadmapApplicationTests {

	@Autowired RoadMapController roadMapController;
	
	@Test
	void contextLoads() {
		assertThat(roadMapController).isNotNull();
	}

}

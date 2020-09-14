package com.demo.roadmap.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoadMapResponse {
	private String origin;
	private String destination;
	private String connected;
}

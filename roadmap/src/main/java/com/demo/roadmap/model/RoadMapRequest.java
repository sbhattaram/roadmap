package com.demo.roadmap.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class RoadMapRequest {
	@NonNull private String origin;
	@NonNull private String destination;
}

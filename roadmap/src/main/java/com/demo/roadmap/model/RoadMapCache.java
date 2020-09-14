package com.demo.roadmap.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class RoadMapCache {
	/*
	 *  Cache will be having Map with in a Map,
	 *  where 1st level map will be having <originCity> 
	 *  that will be having a HashSet map with destination 
	 *  cities that are currently connected.
	 */
	private Map<City, HashSet<City>> cityMapCache = new HashMap<City, HashSet<City>>();
}

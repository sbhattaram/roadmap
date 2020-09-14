package com.demo.roadmap.service.impl;

import static com.demo.roadmap.constant.RoadMapConstants.SPLITOR;

import java.io.File;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.roadmap.model.City;
import com.demo.roadmap.model.RoadMapCache;

@Service
public class RoadMapCacheHandler {
	private static final Logger logger = LoggerFactory.getLogger("RoadMapCacheHandler.class");

	private RoadMapCache roadMapCache;

	@Autowired
	public RoadMapCacheHandler(RoadMapCache roadMapCache) {
		this.roadMapCache = roadMapCache;
	}

	//... H2 db could have been used here but for simplicity purpose
	//... a map is used. Which will initialized while the service is 
	//... started up (during boot starp).
	public void initialize(String filename) throws Exception {
		Map<City, HashSet<City>> cityMapCache = roadMapCache.getCityMapCache();
		File file = new File(filename);
		try (Stream<String> stream = Files.lines(file.toPath())) {
			stream.forEach(line -> {
				HashSet<City> destSet = null;
				String[] split = line.split(SPLITOR);
				City originCity = City.builder().name(split[0]).build();
				City destinationCity = City.builder().name(split[1]).build();
				if(cityMapCache.containsKey(originCity)) {
					destSet = cityMapCache.get(originCity);
				} else {
					destSet = new HashSet<City>();
				}
				destSet.add(destinationCity);
				cityMapCache.put(originCity, destSet);
			});
			logger.info("Loading of file: {} completed - successfully", filename);
			System.out.println(cityMapCache);
		} catch (Exception e) {
			logger.error("Failure to load file: {}, due to exception", filename, e);
			throw e;
		}
	}

	//.. Method to check if the cities are connected
	public boolean areConnected(City origin, City destination) {
		Map<City, HashSet<City>> cityMapCache = roadMapCache.getCityMapCache();
		return cityMapCache.containsKey(origin)? cityMapCache.get(origin).contains(destination) : false;
	}

	public void add() {
		//... TODO: TO BE IMPLEMENTED
		//... To add new connections between the cities can be done.
	}

	public void delete() {
		//... TODO: TO BE IMPLEMENTED
		//... To remove the connection between the cities.
	}

	public Map<City, HashSet<City>> getAllMapping() {
		return roadMapCache.getCityMapCache();
	}
}

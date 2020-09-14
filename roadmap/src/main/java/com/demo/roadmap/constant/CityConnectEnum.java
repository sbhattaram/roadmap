package com.demo.roadmap.constant;

public enum CityConnectEnum {
	
	CONNECTED("yes", true),
	NOT_CONNECTED("no", false);
	
	private String status;
	private boolean isConnected;
	
	public String getStatus() {
		return this.status;
	}
	
	public String getStatus(boolean isConnected) {
		return isConnected? CONNECTED.status : NOT_CONNECTED.status;
	}
	
	CityConnectEnum(String status, boolean isConnected) {
		this.status = status;
		this.isConnected = isConnected;
	}
}

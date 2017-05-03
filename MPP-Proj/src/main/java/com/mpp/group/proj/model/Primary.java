package com.mpp.group.proj.model;

public enum Primary {
	
	OPTION_1("Y", "PRIMARY"), OPTION_2("N", "NONE");

	private String value;
	private String key;

	private Primary(String value, String key) {
		this.value = value;
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}

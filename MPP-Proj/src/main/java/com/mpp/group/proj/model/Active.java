package com.mpp.group.proj.model;

public enum Active {
	
	OPTION_1("Y", "ACTIVE"), OPTION_2("N", "IN-ACTIVE");

	private String value;
	private String key;

	private Active(String value, String key) {
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

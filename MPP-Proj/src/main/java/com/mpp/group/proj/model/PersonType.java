package com.mpp.group.proj.model;
public enum PersonType {

    OPTION_1(1, "DOCTOR"),
    OPTION_2(2, "CUSTOMER"),
    OPTION_3(3, "OTHERS");

	private int value;
	private String key;

	private PersonType(int value, String key) {
		this.value = value;
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
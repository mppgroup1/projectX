package com.mpp.group.proj.model;

public enum ImplantSite {
	
	
DORSAL_SURFACE(1,"DORSAL SURFACE"),
LEFT_SHOULDER(2,"LEFT SHOULDER"),
RIGHT_SHOULDER(3,"RIGHT SHOULDER"),
VENTRAL_AREA(4,"VENTRAL AREA");
	

private int value;
private String key;

private ImplantSite(int value, String key) {
	this.value = value;
	this.key = key;
}

public String getValue(int value) {
	return key;
}

public int getValue( ) {
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

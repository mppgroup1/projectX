package com.mpp.group.proj.model;

import java.util.*;

public class Phone {

	public  Phone(){}
    public Phone(int id){
		this.id = id;
    }
    
    private int id;
    private int pid;
    private int areacode;
    private long telephone;
    private String primary;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getAreacode() {
		return areacode;
	}
	public void setAreacode(int areacode) {
		this.areacode = areacode;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
	}

    @Override
    public String toString(){
    	String s = id + " " + pid + " " + areacode + " " + telephone + " " + primary;
    	
    	return s;
    }
}
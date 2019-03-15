package com.assignment.phone;

public abstract class Phone {
	private String versionNumber;
	private int batteryPercentage;
	private String carrier;
	private String ringTone;
	
	public Phone (String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		this.versionNumber = versionNumber;
		this.batteryPercentage = batteryPercentage;
		this.carrier = carrier;
		this.ringTone = ringTone;
	}
	// abstract method. This will be implemented by the subclasses
	public abstract void displayInfo();
	
	public String getVN() {
		return this.versionNumber;
	}
	
	public void setVN(String VN) {
		this.versionNumber = VN;
	}
	
	public String getC() {
		return this.carrier;
	}
	
	public void setC(String c) {
		this.carrier = c;
	}
	
	public int getBatP(int bP) {
		return this.batteryPercentage;
	}
	
	public void setBatP(int bP) {
		this.batteryPercentage = bP;
	}
	
	public String getR() {
		return this.ringTone;
	}
	
	public void setRing(String rT) {
		this.ringTone = rT;
	}
	
}

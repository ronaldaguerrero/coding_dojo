package com.assignment.phone;

public class IPhone extends Phone implements Ringable{
	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	@Override
	public String ring() { // from Interface Ringable
		return "Ring Ring Ring";
		
	} 
	
	@Override
	public String unlock() { // from Interface Ringable
		return "Unlocking via facial recognition";
	}
	
	@Override
	public void displayInfo() { // from extension Phone
		System.out.println("This is our method from Iphone");
	}
}

package com.assignment.zookeeper;

public class Mammal { 
	private int energyLevel;
	
	public Mammal() {
		energyLevel = 100;
	}
	public int displayEnergy() {
		System.out.println(this.energyLevel);
		return this.energyLevel;
	}
}

package com.assignment.zookeeper2;

public class Bat{ 
	private int energyLevel;
	
	public Bat() {
		energyLevel = 300;
	}
	
	public void fly() {
		this.energyLevel-=50;
		System.out.println("The bat is flying...");
	}
	
	public void eatHumans() {
		this.energyLevel+=25;
		System.out.println("The bat is eating something!?!");
	}
	
	public void attackTown() {
		this.energyLevel-=100;
		System.out.println("THe town is on fire!!!");
	}
}

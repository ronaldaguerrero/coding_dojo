package com.assignment.zookeeper;

public class Gorilla{
	private int energyLevel;
	
	public Gorilla() {
		energyLevel = 100;
	}
	public void throwSomething() {
		System.out.println("The gorilla has thrown something...");
		this.energyLevel-= 5;	
	}
	public void climb() {
		System.out.println("The gorilla is climbing a tree!?!");
		this.energyLevel-=10;
	}
	public void eatBananas() {
		System.out.println("The gorilla is enjoying the banana!");
		this.energyLevel+=10;
	}
	public int displayEnergy() {
		System.out.println(this.energyLevel);
		return this.energyLevel;
	}
}

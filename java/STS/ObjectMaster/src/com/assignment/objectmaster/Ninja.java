package com.assignment.objectmaster;

public class Ninja extends Human{
		
	public Ninja() {
		stealth = 10;
	}
	
	public void runAway() {
		System.out.println("Someone is running away!");
		this.health -= 10;
	}
	
	public void steal(Human stolen) {
		System.out.println("Someone's health is being stolen!");
		int temp = stolen.health;
		stolen.health -= this.health;
		this.health += temp;
	}
}

package com.assignment.objectmaster;

public class Human {
	private String name; 
	public int strength;
	public int stealth;
	public int intelligence;
	public int health;
	
	public Human() {
		this.strength = 3;
		this.stealth = 3;
		this.intelligence = 3;
		this.health = 100;
	}
	public void displayInfo() {
		System.out.println("Strength: " + this.strength);
		System.out.println("Stealth: " + this.stealth);
		System.out.println("Intelligence: " + this.intelligence);
		System.out.println("Health: " + this.health);
	}
	public void attack(Human attacked) {
		System.out.println("Someone is being attacked!");
		attacked.health -= this.strength;
		System.out.println(attacked.health);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

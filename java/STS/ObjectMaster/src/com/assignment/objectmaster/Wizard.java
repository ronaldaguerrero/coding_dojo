package com.assignment.objectmaster;

public class Wizard extends Human{ 
	
	public Wizard() {
		health = 50;
		intelligence = 8;
	}
	
	public void heal(Human healed) {
		healed.health += this.intelligence;
		System.out.println("Someone is being healed");
		System.out.println(healed.health);
	}
	public void fireball(Human fireballed) {
		fireballed.health -= (this.intelligence * 3);
		System.out.println("Someone is being fireballed");
		System.out.println(fireballed.health);
	}
}

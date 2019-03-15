package com.assignment.objectmaster;

public class Samurai extends Human{
  	
	private static int counter = 0;
	public Samurai() {
		this.health = 200;
		counter++;
	}
	public void deathBlow(Human attk) {
		attk.health -= attk.health;
		this.health -= (this.health / 2);
		System.out.println("Victim's health: " + attk.health);
		System.out.println("Samurai's helath: " + this.health);
		System.out.println("Someone's taking a deathblow!");
	}
	public void medidate() {
		this.health += (this.health / 2);
		System.out.println("Samurai is meditating...");
	}
	public int howMany(){
		System.out.println(counter);
		return counter;
		
	}
}

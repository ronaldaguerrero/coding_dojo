package com.assignment.objectmaster;

public class subclassHumanTest {

	public static void main(String[] args) {
		Human newH = new Human();
		Human newH2 = new Human();
		newH.attack(newH2); // newH is being executed along w/ its attributes, followed by the attack method
		newH.displayInfo();
		Ninja newN = new Ninja();
		newN.steal(newH);
		newN.runAway();
		Wizard newW = new Wizard();
		newW.heal(newH);
		newW.fireball(newH);
		Samurai newS = new Samurai();
		newS.deathBlow(newH);
		newS.medidate();
		Samurai newS1 = new Samurai();
		newS1.howMany();
	}

}

package com.assignment.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Human newH = new Human();
		Human newH2 = new Human();
		newH.attack(newH2); // newH is being executed along w/ its attributes, followed by the attack method
		newH.displayInfo();
		
	}

}

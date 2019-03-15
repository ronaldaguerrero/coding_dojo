package com.assignment.operatebicycle;

class BicycleTest {

	public static void main(String[] args) {
		Bicycle b = new Bicycle();
		System.out.println(Bicycle.myConstant); // from Interface class
		b.sayHello(); // from Interface class
		Bicycle.staticMethod(); // from Interface class
		b.speedUp(3); // from Bicycle class
		b.applyBrakes(2); // from Bicycle class
		System.out.println(b.getSpeed()); // from Bicycle class

	}

}

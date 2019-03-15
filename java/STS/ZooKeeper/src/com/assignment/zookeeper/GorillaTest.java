package com.assignment.zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
		Gorilla gType = new Gorilla();
		gType.throwSomething();
		gType.displayEnergy();
		Gorilla gType2 = new Gorilla();
		gType2.climb();
		gType2.displayEnergy();
		Gorilla gType3 = new Gorilla();
		gType3.eatBananas();
		gType3.displayEnergy();
//		 Test Class
		Gorilla gType4 = new Gorilla();
		gType4.throwSomething();
		gType4.throwSomething();
		gType4.throwSomething();
		gType4.eatBananas();
		gType4.eatBananas();
		gType4.climb();

	}

}

package com.assignment.phone;

public class PhoneTester {

	public static void main(String[] args) {
		Galaxy s9 = new Galaxy("S9", 99, "AT&T", "Rang Rang");
		IPhone iphoneTen = new IPhone("X", 100, "Cricket Wireless", "cricket cricket");
		
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());
		
		iphoneTen.displayInfo();
		System.out.println(iphoneTen.ring());
		System.out.println(iphoneTen.unlock());
		

	}

}

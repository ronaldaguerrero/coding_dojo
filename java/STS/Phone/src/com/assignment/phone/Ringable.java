package com.assignment.phone;

public interface Ringable {
	default String ring() {
		return "ring"; 
	}
	default String unlock() {
		return "unlocked";
	}
}


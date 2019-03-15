package com.assignment.calculator;

public class Calculator {
	double result;	
	String operator;
	double one;
	double two;
	
	public Calculator() {
	}
	
	public void setOperandOne(double num) {
		one = num;
	}
	
	public void setOperandTwo(double num) {
		two = num;
	}
	
	public void setOperation(String symbol) {
		if (symbol == "+") {
			operator = "+";
		}
		else if (symbol == "-") {
			operator = "-";
		}
	}
	
	public void performOperation() {
		if (operator == "+") {
			result = one + two;
		} else {
			result = one - two;
		}
	}
	
	public double getResults() {
		return result;
	}
	
}

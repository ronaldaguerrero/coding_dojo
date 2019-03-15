package com.assignment.calculator2;

public class Calculator2Test {

	public static void main(String[] args) {
		Calculator2 calc1 = new Calculator2();
		calc1.performOperation(10.5);
		calc1.performOperation("+");
		calc1.performOperation(5.2);
		calc1.performOperation("*");
		calc1.performOperation(10);
		System.out.println(calc1.getResults());
		System.out.println(calc1.evaluate("10.5 + 5 * 10"));

	}

}

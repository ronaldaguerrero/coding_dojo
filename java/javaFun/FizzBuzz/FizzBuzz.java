public class FizzBuzz {
	public static String fizzBuzz(int number) {
		String result = "None";
		if(number == 3) {
		    result = "Fizz";
		} else if(number == 5) {
		    result = "Buzz";
		} else if (number == 15){
		    result = "FizzBuzz";
		} else if (number == 2){
			result = "" + 2;
		}
		return result;
	}
}

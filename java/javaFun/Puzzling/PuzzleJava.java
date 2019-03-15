import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;

public class PuzzleJava{
	public static void main(){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(4);
		numbers.add(3);
		numbers.add(2);
		numbers.add(1);

		Collections.shuffle(numbers);
		System.out.println(numbers); // [1, 5, 2, 4, 3]
		Collections.sort(numbers);
		System.out.println(numbers); // [1, 2, 3, 4, 5]

		Random r = new Random();
		System.out.println(r.nextInt()); // without bounds
		System.out.println(r.nextInt(5)); // with bounds 0 to 5
	}
	public static void printSum(int[] array){
		int sum = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++){
			sum += array[i];
			if (array[i] > 10){
				arr.add(array[i]);
			}
		}
		System.out.println("Sum is: " + sum);
		System.out.println("Array is: " + arr);
	}
	public static void shuffle(ArrayList<String> array){
		ArrayList<String> newArr = new ArrayList<String>();
		Collections.shuffle(array);
		System.out.println("This is the shuffled array" + array);
		for (int i = 0; i < array.size(); i++){
			if(array.get(i).length() > 5){
				newArr.add(array.get(i));
			}
		}
		System.out.println("These names are longer than 5 char " + newArr);
	}
	public static void alphabet(){
		ArrayList<Character> alphaArr = new ArrayList<Character>();
		for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
 		   alphaArr.add(alphabet);
		}
		System.out.println("This is the alphabet array: " + alphaArr);
		Collections.shuffle(alphaArr);
		System.out.println("This is the last element in the shuffled arraylist: " + alphaArr.get(alphaArr.size()-1));
		if (alphaArr.get(0) == 'A' || alphaArr.get(0) == 'E' || alphaArr.get(0) =='I' || alphaArr.get(0) =='O' || alphaArr.get(0) =='U'){
			System.out.println("The first element in the shuffled arraylist is a vowel: " + alphaArr.get(0));
		} else {
			System.out.println("This is the first element in the shuffled arraylist: " + alphaArr.get(0));
		}
	}
	public static void randomOne(){
		ArrayList<Integer> randomArr = new ArrayList<Integer>();
		while (randomArr.size() < 10){
			Random r = new Random();
			int num = r.nextInt(100 - 55) + 55;
			randomArr.add(num);
		}
		System.out.println(randomArr);
	}
	public static void randomTwo(){
		ArrayList<Integer> randomArr = new ArrayList<Integer>();
		while (randomArr.size() < 10){
			Random r = new Random();
			int num = r.nextInt(100 - 55) + 55;
			randomArr.add(num);
		}
		Collections.sort(randomArr);
		System.out.println(randomArr);
	}
	public static void randomString(int n){
		String set = "0123456789abcdefghijklmnopqrstuvwxyz"; // creating a string of characters
		StringBuilder sb = new StringBuilder(); // creates a new string
		Random r = new Random(); // sets random 
		for (int i = 0; i <= n; i++) { 
			int index = r.nextInt(set.length()); // generates a random num in set between 0 and its length)
			char c = set.charAt(index); // assigns the random char index to c 
			sb.append(c);  // appends to c
		}
		System.out.println(sb.toString());
	}
	public static void randomArrays(int n){
		ArrayList<Object> randomArr = new ArrayList<Object>();
		String set = "0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(); // creates a new string
		while (randomArr.size() < 10){
			Random r = new Random(); // sets random 
			for (int i = 0; i <= n; i++) { 
			int index = r.nextInt(set.length()); // generates a random num in set between 0 and its length)
			char c = set.charAt(index); // assigns the random char index to c 
			sb.append(c);  // appends to c
			}
			randomArr.add(sb.toString());
			sb = new StringBuilder();
		}
		System.out.println(randomArr);
	}
}
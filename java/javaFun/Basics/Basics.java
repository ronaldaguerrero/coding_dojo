import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;

public class Basics {
	// print 1 - 255
	public static void print1To255() {
		for (int i = 0; i < 256; i++) {
			System.out.println(i);
		}
	}
	// end
	// print odd #'s 1 - 255
	public static void printOddsTo255() {
		for (int i = 0; i < 256; i++) {
			if (i % 2 == 1){
				System.out.println(i);
			}
		}
	}
	// end
	// print Sum 0 to 255
	public static void printSumTo255() {
		int sum = 0;
		for (int i = 0; i < 256; i++) {
			sum+= i;
			System.out.println("New number: " + i + " Sum: " + sum);
		}
	}
	// end
	// Iterate through an array
	public static void itArray(int[] array) {
	for (int arr : array) {
			System.out.println("Number in array: " + arr);
		}
	}
	// end
	// Find Max
	public static void findMax(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i ++) {
			if (array[i] >= max) {
				max = array[i];
			}
		}
		System.out.println("Max # in array: " + max);
	}
	// 	end
	// 	Get Average
	public static void getAvg(int[] array) {
		int sum = array[0];
		for (int i = 1; i < array.length; i++){
			sum+= array[i];
		}
		int avg = sum / array.length;
		System.out.println("Avg is : " + avg);
	}
	// 	end
	// 	Array w/ odd #'s
	public static void arrayWithOdds(){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (Integer y = 0; y < 256; y++){
			if (y % 2 == 1){
				arr.add(y);
			}
		}
		System.out.println(arr);
	}
	// end
	// Greater than Y
	public static void greaterThanY (int[] array, int y){
		int count = 0;
		for (int i = 0; i < array.length; i++){
			if (y < array[i]){
				count++;
			}
		}
		System.out.println(count);
	}
	// end
	// Square the values
	public static void squareValues (int[] array){
		for (int i = 0; i < array.length; i++){
			array[i] = (int) Math.pow(array[i],2);
		}
		System.out.println(Arrays.toString(array));
	}
	// end
	// Eliminate negative numbers
	public static void elimNegNums (int[] array){
		for (int i = 0; i < array.length; i++){
			if (array[i] < 0){
				array[i] = 0;
			}
		}
		System.out.println(Arrays.toString(array));
	}
	// end
	// Max, Min, and Average
	public static void maxMinAvg (int[] array){
		int min = array[0];
		int max = array[0];
		for (int i = 1; i < array.length; i++){
			if (array[i] > max){
				max = array[i];
			}
			if (array[i] < min){
				min = array[i];
			}
		}
		int avg = max / array.length;
		int[] newArray = {max, min, avg};
		System.out.println(Arrays.toString(newArray));
	}
	//end
	// Shifting the values in the array
	public static void shiftingArray (int[] array){
		for (int i = 0; i < array.length-1; i++){
			if (i < array.length-1){
				array[i] = array[i + 1];
			}
		}
		array[array.length - 1] = 0;
		System.out.println(Arrays.toString(array));
	}
	// end
}
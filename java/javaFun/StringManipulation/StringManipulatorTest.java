public class StringManipulatorTest{
	public static void main(String[] args) {
		StringManipulator manipulator = new StringManipulator();
		// Start of Task 1
		// String str = manipulator.trimAndConcat("   Hello    ","    World    ");
		// System.out.println(str);
		// End of Task 1
		// Start of Task 2
		// char letter = 'o';
		// Integer a = manipulator.getIndexOrNull("Coding", letter);
		// Integer b = manipulator.getIndexOrNull("Hello World", letter);
		// Integer c = manipulator.getIndexOrNull("Hi", letter);
		// System.out.println(a);
		// System.out.println(b);
		// System.out.println(c);
		// End of Task 2
		// Start of Task 3
		// String word = "Hello";
		// String subString = "llo";
		// String notSubString = "world";
		// Integer a = manipulator.getIndexOrNull(word, subString);
		// Integer b = manipulator.getIndexOrNull(word, notSubString);
		// System.out.println(a); 
		// System.out.println(b);
		// End of Task 3
		// Start of Task 4
		String word = manipulator.concatSubstring("Hello", 1, 2, "world");
		System.out.println(word);
	}
}
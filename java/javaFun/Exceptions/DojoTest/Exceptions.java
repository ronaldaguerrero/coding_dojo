import java.util.ArrayList;

public class Exceptions {
		public static void testing(){
			ArrayList<Object> arrList = new ArrayList<>();
			myList.add("13");
			myList.add("hello world");
			// myList.add(48);
			myList.add("Goodbye World");
		for(int i=0; i<arrList.size(); i++){
			try {
				Integer value = (Integer) myList.get(i);
				System.out.println(value);
			} catch(ClassCastException e) {
				System.err.println("ERROR ON INDEX: " + i);
			}
		}
	}
}
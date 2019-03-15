public class Greeter {
    public String greet(String name){
        return createGreeting(name);
    }
    // public String greet(){
    //     return "Hello World";
    public String greet(){
    	return createGreeting("World");
    }
    public String greet(String firstName, String lastName){
    	System.out.println("We are about to greet " + firstName);
    	return createGreeting(firstName + " " + lastName);
    }
    private String createGreeting(String toBeGreeted){
    	return "Greeting " + toBeGreeted + ", welcome to coding dojo";
    }
    public static void testGreeting(String name){
    	System.out.println("this is a test of static method");
    }
}
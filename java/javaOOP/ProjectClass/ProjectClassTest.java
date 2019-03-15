public class ProjectClassTest{
	public static void main(String[] args){
		ProjectClass pro2 = new ProjectClass("NBA");
		ProjectClass pro1 = new ProjectClass("NFL", "NFL description");
		ProjectClass pro3 = new ProjectClass("WNBA");
		System.out.println("This is the name for pro2 : " + pro2.getName());
		System.out.println("This is the name for pro1 : " + pro1.getName() + ". Description : " + pro1.getDesc());
		System.out.println("This is the name for pro3 : " + pro3.getName());
		System.out.println("This is the elevator pitch for pro1 : " + pro1.elevatorPitch());
		System.out.println("Updating pro3...");
		pro3.setName("WNFL");
		System.out.println("This is the new name for pro3 : " + pro3.getName());
	}
}
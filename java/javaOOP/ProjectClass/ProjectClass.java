public class ProjectClass{
	private String name;
	private String desc;

	public ProjectClass(){
		System.out.println("hello");
	}
	public ProjectClass(String nameP){
		this.name = nameP;
	}
	public ProjectClass(String nameP, String descP) {
		this.name = nameP;
		this.desc = descP;
	}	
	public String getName(){
		return name;
	}
	public String getDesc(){
		return desc;
	}
	public String elevatorPitch(){
		return name + ":" + desc;
	}
	public void setName(String nameP){
		this.name = nameP;
	}
	public void setDesc(String descP){
		this.desc = descP;
	}
}
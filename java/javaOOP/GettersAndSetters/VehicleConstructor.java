class VehicleConstructor {
    private int numberOfWheels;
    private String color;
    // ex. new VehicleConstructor() in test file | which creates new Vehicle()
    public VehicleConstructor(){
    }
    // ex. new VehichleConstructor("someColor") | which sets the color
    public VehicleConstructor(String color) {
        // setting the color attribute to the value from the color parameter
        this.color = color;
    }
    public VehicleConstructor(String color, int num){
    	this.color = color;
    	this.numberOfWheels = num;
    }
    public String getInfo() {
        return color;
    }
}
class VehicleConstructoTest {
    public static void main(String[] args) {
        VehicleConstructor redVehicle = new VehicleConstructor("red");
        String color = redVehicle.getColor();
        System.out.println("The Vehicle color is: " + color);
    }
}
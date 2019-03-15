import java.lang.Math;
public class Pythagorean {
	public double calculateHypotenuse(int legA, int legB){
		double legC = (Math.pow(legA,2)) + (Math.pow(legB,2));
		double squareRoot = Math.sqrt(legC);
		return squareRoot;
	}
}

public class Add implements Math{
	
	private int x;
	private int y;
	
	public Add(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int calculate() {
		return x+y;
	}
	//single responsibility principle
	//there are many ways to calculate in math
	//separate the functions of calculation into
	//classes so it can be used outside of just Math
	//and does not depend on Math class.
	//-----------------------------------------------------UPDATE BELOW-------------------------------
	//THIS IS NOT single responsibility principle
	//single responsibility principle breaks up a class in to multiple classes
	//if there are methods that should be separated, it will be separated into different classes
	//Single responsibility does NOT break an interface like Math does to Add and Subtract
	//A better example is using Calculator class and splitting it into Add and Subtract class for their respective methods
}

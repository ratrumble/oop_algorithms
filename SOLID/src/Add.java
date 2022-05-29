
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
}

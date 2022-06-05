
public class Vehicle {

	protected int num;
	//all(including private) instance variables will still be inherited by child classes 
	//not just method or constructors
	
	public Vehicle() {
		num = 5;
		System.out.println("Parent class is always invoked on creation of child object");
	}
	
	public void soundHonk() {
		System.out.println("Vehicle Sound");
	}
	
	public int getNum() {
		return num;
	}
	
}

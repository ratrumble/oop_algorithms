
public class Parent {

	protected int num;
	//protected allows for 
	
	public Parent() {
		num = 5;
		System.out.println("Parent class is always invoked on creation of child object");
	}
	
	public void doSomething() {
		num += 1;
	}
	
	public int getNum() {
		return num;
	}
	
}


public class StaticMethod {
	
	public static int x; //static variables can also be called class variables because they are class level
	//shared among all instanced objects
	//can be accessed through both static and nonstatic methods
	public static int y = 123;
	
	private int instanceVar = 12;
	
	static { //static block to initialize
		//or reinitialize if multiple static blocks are used
		x = 1;
	}
	
	public static void staticMethod() {
		System.out.println("Static method");
	}
	public void nonstatic() {
		System.out.println("Non static method");
	}
	
	public void addX(int num) {
		this.x += num;
		//addXStatic(num); instead. Static methods can be accessed
		//on static/nonstatic methods
	}
	
	public static void addXStatic(int num) {
		x += num; //cannot this.x in static method
		
		//instanceVar = 13; nonstatic CANNOT be accessed in static.
		//only other way around
	}
	
	//STATIC CLASSES
	//can only be made in nested classes
	static class nestedClass{
		//can only access static variables from outer class
	}
	
	public static void main(String args[]) {
		staticMethod(); //have to add Class.Method() outside of source class
		StaticMethod object = new StaticMethod();
		object.nonstatic();
		//static methods do not need an object to be called
		//the other methods are instanced by class object. Static methods are not
		object.addX(1);
		addXStatic(1);
		System.out.println(x); //both ways work
		nestedClass x = new nestedClass(); //or StaticMethod.nestedClass x = new StaticMethod.nestedClass();
	}
}


public class ConstructorExample {

	public static void main (String args[]) {
		ConstructorExample defaultConstructor = new ConstructorExample();
		//default constructors will NOT be implicitly implemented if there are any other constructors defined
	}
	//constructors may or may not have parameters
	
	//classes with only a parameterized constructor will not have a default constructor because
	//there is already a defined constructor
}

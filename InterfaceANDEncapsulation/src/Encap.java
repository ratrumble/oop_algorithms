
public class Encap {
//encapsulation hides private implementation details and only allows outside classes to access private variables using public methods
	private int var;
	
	public int getInt() {
		return var;
	}
	
	public void setInt(int i) {
		var = i;
	}
	
	//getters and setters are both ways to change and get private instance variables
	//public methods will call it, not knowing how exactly it is done
	//can only be accessed through public methods, not directly
	
	
	//the advantage of encapsulation is that the methods can always be changed without needing to change implementation throughout
	//all code across other classes, code won't break
	
	//can make variables read/write only depending on how accessible you want it to be (having/not having getters and setters affect this)
	
}

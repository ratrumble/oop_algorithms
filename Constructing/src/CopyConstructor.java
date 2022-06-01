
public class CopyConstructor {
	
	private int x;
	
	public CopyConstructor(int x) {
		this.x = x;
	}
	
	public CopyConstructor(CopyConstructor c) {
		this.x = c.getX();
	}
	
	public int getX() {
		return x;
	}
	
	//this copy constructor takes a class-matching type
	//and copies the instance variables
}

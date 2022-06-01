
public class Chain {

	
	private int s;
	private int y;
	
	public Chain() {
		this(5);
	}
	//constructors can be overloaded
	public Chain(int s) {
		this(s, 6);
	}
	
	public Chain(int s, int y) {
		this.s = s;
		this.y = y;
	}
	
	public static void main(String args[]) {
		Chain chain = new Chain();
		//starts at first constructor and chains to the other ones
	}
}

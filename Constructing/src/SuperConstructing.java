
public class SuperConstructing extends Chain{

	
	private int x;
	private int y;
	
	public SuperConstructing(int x, int y) {
		super(x, y);
	}
	
	public SuperConstructing() {
		x = 6;
		y = 6;
	}
	//super is NOT required for child classes, at least for defined parent classes
	//parameters much have matching types
}

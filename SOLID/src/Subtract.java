
public class Subtract implements Math{
	private int x;
	private int y;
	
	public Subtract(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int calculate() {
		return x-y;
	}
}

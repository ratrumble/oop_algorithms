
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
}

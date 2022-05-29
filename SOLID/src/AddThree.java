
public class AddThree implements Math{
//open closed. Do not change Add, make new way to Add
	private int x;
	private int y;
	private int z;
	
	public AddThree(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public int calculate() {
		return x + y + z;
	}

}

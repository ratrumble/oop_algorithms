
public class AddThree implements Math{
//open closed. Do not change Add, make new way to Add
	//this makes a new way to Add as we take in three variables instead of two
	//does not change the Add class
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

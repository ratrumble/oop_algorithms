
public interface Math {
	public int calculate();
	
	//Give calculations to their own class
	//any class that does not calculate
	//will not use this interface because of Liskov
	//substitution principle
	
}


public interface Math {
	public int calculate();
	
	//Give calculations to their own class
	//any class that does not calculate
	//will not use this interface because of Liskov
	//substitution principle
	//----------------------------UPDATE BELOW
	//Liskov substitution principle does NOT apply to interfaces
	//that is for interface segregation principle
	//Liskov substitution principle separates a child CLASS from a base CLASS if the base class
	//has many methods that the child class does not use
	//for example, a Bicycle class may not have a Car class as its base class because a car class has methods like
	//fillGas(), even when a Bicycle has other similarities such as drive(). Since it cannot use a large part of the Car class.
	//it must be its own Base class as per Liskov
	
}

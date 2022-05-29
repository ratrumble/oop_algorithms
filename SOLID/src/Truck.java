
public interface Truck extends Vehicle{
	public void checkCarriage();
	//interface segregation
	//some vehicles have different actions
	//permissible and those actions will not be
	//included in the Vehicle interface
	//but in more specific interfaces like Truck
	//since many other vehicles may not use carriage
}

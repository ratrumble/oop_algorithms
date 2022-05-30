
public class TruckDriver implements Truck{

	@Override
	public void drive() {
		System.out.println("Shift stick to drive, press pedal");
	}

	@Override
	public void fillGas() {
		System.out.println("Choose diesel");
		
	}

	@Override
	public void checkCarriage() {
		System.out.println("Look behind you");
	}
//same methods as TruckVehicle, different implementations of method
//dependency inversion principle
	
	//a better example of dependency inversion, if I ever need to explain it to someone else
	//use the ATM example, where a customer uses an ATM machine
	//effectively shows a better example of a user and provider
}

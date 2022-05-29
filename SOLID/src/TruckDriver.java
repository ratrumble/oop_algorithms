
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
}

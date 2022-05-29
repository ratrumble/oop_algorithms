
public class TruckVehicle implements Truck{
	public void checkCarriage() {
		System.out.println("BEEP!");
	}

	@Override
	public void drive() {
		System.out.println("Vroom");
	}

	@Override
	public void fillGas() {
		System.out.println("Full");
		
	}
}

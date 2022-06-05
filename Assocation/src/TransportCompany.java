public class TransportCompany{
   public static void main(String args[])
   {
	Driver obj = new Driver("Andy", "Ford", 9988);
	System.out.println(obj.driverName+" is a driver of car Id: "+obj.carId);
   }
}
//association can just be the print statement above.
//the Driver class does NOT have to be extended from Car to count as association, but it can still work as it takes functionality.
//while the Car object does not directly use anything from Driver, it is still used ALONG with a Driver object, and so there is association
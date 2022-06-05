public class Address
{
   private int streetNum;
   private String city;
   private String state;
   private String country;
   public Address(int street, String c, String st, String coun)
   {
       this.streetNum=street;
       this.city =c;
       this.state = st;
       this.country = coun;
   }
}
//Address will NOT be redefined in other classes, nor does it use the other classes in the Address class
//This is because aggregation is one-way, only the other classes will be using Address
//Aggregation is useful so that every class does not have to re=use code to define what could just be an Address object
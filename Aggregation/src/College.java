public class College
{
   private String collegeName;
   //Creating HAS-A relationship with Address class
   private Address collegeAddr; 
   public ollege(String name, Address addr){
       this.collegeName = name;
       this.collegeAddr = addr;
   }
}
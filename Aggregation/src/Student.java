public class Student
{
   private int rollNum;
   private String studentName;
   //Creating HAS-A relationship with Address class
   private Address studentAddr; 
   public Student(int roll, String name, Address addr){
       this.rollNum=roll;
       this.studentName=name;
       this.studentAddr = addr;
   }
}
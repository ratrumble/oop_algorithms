class Demo extends MyClass{
   /* Must Override this method while extending
    * MyClas
    */
   public void disp2()
   {
       System.out.println("overriding abstract method");
   }
   public static void main(String args[]){
       Demo obj = new Demo();
       //MyClass obj1 = new Demo(); abstract class type can be used as reference
       obj.disp2();
   }
   
   //abstract void badMethod();
   
}
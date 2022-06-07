class SuperClass
{
   int num = 100;
   protected void printObject()
   {
       printNumber();
   }
   public void printNumber(){
       System.out.println(num);
   }
   
   public final void finalOne()
   {
       System.out.println("finalOne");
   }
   
   public final void finalOne(int x)
   {
       System.out.println("finalOne(x)");
   }
   
   public SuperClass returnObject() {
	   return this;
   }
   
//private void printNumber() will not work because visibility does not affect overload
   
   //public static void printNumber() will not work, detected as a duplicate (compile time)
   //public static void printNumber(int num) will
	   
   
}

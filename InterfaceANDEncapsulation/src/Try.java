interface Try
{
	/**
   int a=10;
   public int a=10;
   public static final int a=10;
   final int a=10;
   static int a=0;
   **/
   //all statements are identical because class variables are PUBLIC STATIC FINAL by default
	
	//methods must all be abstract, are abstract implicitly

	public abstract void method();
	public void method1();
	//can only have abstract methods
	
	//visibility must be public
	//abstract class can be protected AND its variables can be static final or static but that is optional
}
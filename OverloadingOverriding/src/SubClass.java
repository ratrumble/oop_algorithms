import java.util.ArrayList;
/**abstract**/ class SubClass extends SuperClass
{
   int num = 110;
   // private, static and final methods cannot be overridden as they are local to the class.
   // private void printNumber(){ 
   public void printNumber() {
	/* Note that instead of writing num we are
	 * writing super.num in the print statement
	 * this refers to the num variable of Superclass
	 */
	//super.printNumber();
	System.out.println(num);
   }
   public int printNumber(int num) {
	   return num;
   }//overloading, diff arg, diff return type
   
   public SubClass returnObject() {
	   return this;
   }//override with more specific return type
   
   /** public int returnObject() {
	   return num;
   } INCOMPATIBLE return type error**/
   public static void main(String args[]){
       ArrayList<SuperClass> objs = new ArrayList<SuperClass>();
	   SuperClass obj= new SubClass();
	   objs.add(obj);
	   obj = new SuperClass();
	   objs.add(obj);
	   
	   for(SuperClass o : objs)
	   {
            o.printObject();
            o.finalOne();
            o.finalOne(1);
	   }
   }
}
//overload is checked at compile time, better performance than overriding
//override checked at run time

//static methods can be overloaded, NOT overridden
//same goes for private/final methods

//overloading doesn't care about return type, only signature
//overriding return type must be the same return type or more specific(like SuperClass to SubClass)

//change args while overloading, not while overriding

//static binding is used for overload, dynamic binding for overriding
//same thing for polymorphism. overload = compile time polymorphism = static polymorphism
//override = run time polymorphism = dynamic polymorphism

/**
 * ABC obj = new ABC();
obj.myMethod();
// This would call the myMethod() of parent class ABC

XYZ obj = new XYZ();
obj.myMethod();
// This would call the myMethod() of child class XYZ

ABC obj = new XYZ();
obj.myMethod();
// This would call the myMethod() of child class XYZ
 * 
 * Polymorphism is useful for these types of classes,
 * can downcast all parent objects and call "generic" methods
 * that will behave differently depending how far the override goes
 */

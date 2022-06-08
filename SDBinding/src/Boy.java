class Boy extends Human{
   public static void walk(){
       System.out.println("Boy walks");
   }
   //when a method is static, private, or final, it CANNOT be overridden
   //static/private/final are considered static binding BECAUSE they cannot be overridden
   //static binding is not limited to overrides/not override. it also works for overload
   
   //BINDING is an association between method definition and method call
   
   //everything else that allows overrides is DYNAMIC binding, override occurs at runtime
   public static void main( String args[]) {
       /* Reference is of Human type and object is
        * Boy type
        */
       Human obj = new Boy();
       /* Reference is of Human type and object is
        * of Human type.
        */
       Human obj2 = new Human();
       obj.walk();
       obj2.walk();
   }
}
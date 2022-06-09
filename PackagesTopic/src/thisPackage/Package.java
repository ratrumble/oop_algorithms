package thisPackage; //declare package


public class Package {
	//two different types of packages
	//built in and user defined
	
	//ex. java.util.Scanner
	//java is the top level package
	//util is sublevel
	//Scanner is class being imported
	
	//why useful?
	//can reuse code using packages for classes you need
	//organization
	//avoid name conflicts by using different packages
	
	//how to create a class inside package
	
	//declare package

	//can then declae import thisPackage.package in another program and use methods
	public void doNothing() {
		System.out.println("do nothing");
	}
	
	//declaring a subpackage would look something like this
	//package Package.subPackage where Package is the main package
	//and subPackage is a subpackage
	
	//in order to use classes with same name but different package
	//you MUST use the no import method or there will be a compilation
	//error
	//ex. xPackage.obj obj = new xPackage.obj();
	//yPackage.obj obj = new yPackage.obj(); where obj is class name
}

package thisPackage; //can only have 1 package, import many though
import thisPackage.Package; //import MUST be after package declaration
//to wildcard import you can call
import thisPackage.*; //but it will not import subPackage classes
//unless you add the subpackage after thisPackage.
//it will look like thisPackage.subPackage.*; instead

public class test {
	public static void main (String args[]) {
		Package obj = new Package();
		obj.doNothing();
	}
}

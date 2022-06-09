package thisPackage;

public class NoImport {
	public void something() {
		thisPackage.Package obj = new thisPackage.Package();
		//use Package obj without importing
		//must use packagename.classname
	}
}

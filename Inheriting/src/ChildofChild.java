
public class ChildofChild extends Car{
	
	protected int gnum;

	public ChildofChild() {
		//super().super(); //WILL not work because it violates encapsulation
		//super();
	} //this existing turns the inheritance type to multilevel
}

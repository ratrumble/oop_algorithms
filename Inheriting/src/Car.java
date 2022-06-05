import java.util.ArrayList;

public class Car extends Vehicle{

	protected int childNum;
	
	public Car() {
		super();
		childNum = 7;
		System.out.println("From child class");
	}
	
	public Car(int childNum) {
		this.childNum = childNum;
	}
	
	public int getNum() {
		childNum += super.getNum();
		return childNum;
	}
	
	public int getChildNum() 
	{
		return childNum;
	}
	
	public void soundHonk() {
		System.out.println("Car sound");
	}
	
	public static void main (String args[]) {
		Vehicle parent = new Vehicle();
		Vehicle childParent = new Car();
		Car child = new Car();
		System.out.println(child.getNum() + " childNum");
		//child.childNum = parent.num; //doable because Child is a subclass of Parent and the .num instance variable is protected
		//parent = (Child) parent; //no downcasting, only on initialization
		if(parent instanceof Car)
		{
			child = (Car)parent;
		}
		child = (Car) childParent;
		ArrayList<Vehicle> parentList = new ArrayList<Vehicle>();
		parentList.add(childParent);
		parentList.add(child);
		parentList.add(parent);
		for(Vehicle vehi : parentList)
		{
			vehi.soundHonk();
			//System.out.println(elem.getNum()); //du=ynamic bounding... upcasted childParent will stlil use Child overridden method
			//parent.getChild();
		}
		//child = (Parent) child; NO upcasting, only downcasting
		//Child parentChild = new Parent(); //no upcasting on initialization
		ChildofChild gChild = new ChildofChild();
		child.childNum = gChild.gnum; //protected is available for everything within the package
		HierarchicalClass hChild = new HierarchicalClass();
		child.childNum = hChild.hnum; //as stated before
		NoInstanceVar noInstanceChild = new NoInstanceVar();
		System.out.println(noInstanceChild.getNum());
	}
	//this type of inheritance would be called single inheritance because there is only one parent and subclass
	//multiple subclasses to one parent would be called hierarchical inheritance
	//subclasses with subclasses would be called multilevel inheritance
	//there can be a hybrid of multilevel and hierarchical
	//multiple inheritance where a child has 2 parents is NOT allowed
	
	
	
}


public class Child extends Parent{

	protected int childNum;
	
	public Child() {
		super();
		System.out.println("From child class");
	}
	
	public Child(int childNum) {
		this.childNum = childNum;
	}
	
	public static void main (String args[]) {
		Parent parent = new Parent();
		Child child = new Child();
		System.out.println(child.getNum());
		child.childNum = parent.num; //doable because Child is a subclass of Parent and the .num instance variable is protected
		parent = (Child) parent; //allowed
		//child = (Parent) child; NO upcasting, only downcasting
		ChildofChild gChild = new ChildofChild();
		child.childNum = gChild.gnum; //protected is available for everything within the package
		HierarchicalClass hChild = new HierarchicalClass();
		child.childNum = hChild.hnum; //as stated before
	}
	//this type of inheritance would be called single inheritance because there is only one parent and subclass
	//multiple subclasses to one parent would be called hierarchical inheritance
	//subclasses with subclasses would be called multilevel inheritance
	//there can be a hybrid of multilevel and hierarchical
	//multiple inheritance where a child has 2 parents is NOT allowed
	
	
	
}

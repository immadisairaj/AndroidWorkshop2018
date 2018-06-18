class Parent{
	int number = 1002;
	String favFruit = "Watermelon";
	String name = "?";
	int rollNo = 17306;
}

public class ParentChild extends Parent{
	
	int number = 1004;
	String favFruit = "Mango";
	int rollNo = 16002;

	public void print1(){
		System.out.println("Parent "+super.number);
		System.out.println(super.favFruit+" "+super.name);
	}

	public void print2(){
		System.out.println(super.rollNo);
	}

	public static void main(String args[]){
		ParentChild parentChild = new ParentChild();
		System.out.println("Child "+parentChild.number);
		parentChild.print1();
		System.out.println(parentChild.favFruit+" "+parentChild.rollNo);
		parentChild.print2();
	}
}
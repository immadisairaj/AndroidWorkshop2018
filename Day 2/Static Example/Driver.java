public class Driver{
	String name = "rajendra";
	static String name2 = "raj";

	public void print(){
		System.out.println("Normal");
	}

	public static void print2(){
		System.out.println("Static");
	}

	public static void main(String args[]){
		Driver driver = new Driver();

		System.out.println(name);				//Takes only Static 
		System.out.println(driver.name);	//Had to create Object
		System.out.println(name2);

		print();			//Takes only Static
		driver.print();	//Had to create Object
		print2();
	}
}
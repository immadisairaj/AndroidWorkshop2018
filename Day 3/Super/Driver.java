public class Driver extends SuperExample{
	
	public Driver(){
		super();	//it will be there by default
					//for initializing values in parent class
		System.out.println("Child Constructor ");
	}

	@Override
	public void printSomething(){
		super.printSomething();
		System.out.println("Method in child class");
	}

	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.printSomething();
	}
}
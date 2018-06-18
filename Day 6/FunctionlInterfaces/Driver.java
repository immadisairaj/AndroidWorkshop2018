public class Driver implements MyFunctionalInterface {
	public void saySomething(){
		System.out.println("Something !");
	}

	public static void main(String[] args) {

		MyFunctionalInterface myInterface = new MyFunctionalInterface(){
			public void saySomething(){
				System.out.println("Something Anonymous");
			}
		};

		myInterface.saySomething();

		MyFunctionalInterface anotherInterface = () -> System.out.println("Lamda Expression");
		anotherInterface.saySomething();

		Driver driver = new Driver();
		driver.saySomething();
	}
}
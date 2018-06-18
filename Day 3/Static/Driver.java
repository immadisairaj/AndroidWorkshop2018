public class Driver{
	public static void main(String[] args) {

		//for static method
		StaticExample.printSomethingAgain();
		System.out.println("---------------");

		//for non-static method
		StaticExample example = new StaticExample();
		example.printSomething();
	}
}
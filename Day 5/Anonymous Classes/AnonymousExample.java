public class AnonymousExample{
	public static void main(String[] args) {
		//MyInterface myInterface = new MyInterface();	//This is wrong

		MyInterface myInterface = new MyInterface(){	//This is correct
														//This is Anonymus Class
			public void saySomething(){
				System.out.println("something !");
			}
			public void sayHello(){
				System.out.println("hello !");
			}
		};

		myInterface.saySomething();
		myInterface.sayHello();
	}
}
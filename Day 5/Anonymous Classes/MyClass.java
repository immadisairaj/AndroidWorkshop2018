public class MyClass implements MyInterface{
	
	public void saySomething(){
		System.out.println("Something");
	}

	public void sayHello(){
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		myClass.saySomething();
		myClass.sayHello();
	}
}
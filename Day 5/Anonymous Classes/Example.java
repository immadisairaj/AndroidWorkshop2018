public class Example{
	public static void methodA(String a, int b, MyInterface myInterface){
		System.out.println(a+" "+b);
		myInterface.sayHello();
	}

	public static void main(String[] args) {

		MyClass myClass = new MyClass();
		methodA("Abc",010,myClass);

		methodA("Bond",007,new MyInterface(){
			public void sayHello(){
				System.out.println("Helloo");
			}
			public void saySomething(){
				System.out.println("Somethinggggg");
			}
		});
	}
}
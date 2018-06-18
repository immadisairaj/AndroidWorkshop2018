public interface MyFunctionalInterface {
	//void methodA(int number);

	//int methodB(int a, int b);

	String methodC(String a, String b);

	default void methodD(int a, int b) {
		System.out.println("Sum : "+a+b);
	}

	static void staticMethod (String input) {
		System.out.println(input);
	}

	/*private void privateMethod() {
		System.out.println("Private Method");
	}*/
}
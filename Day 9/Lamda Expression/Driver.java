public class Driver {
	
	public static void main(String[] args) {
		
		/*MyFunctionalInterface obj = (num) -> {
			System.out.println(num);
		};

		obj.methodA(51);*/

		/*MyFunctionalInterface obj = (c,d) -> {
			return c+d;
		};

		int result = obj.methodB(3,5);
		System.out.println(result);*/

		MyFunctionalInterface obj = (c,d) -> {
			return c+d;
		};

		String result = obj.methodC("Raj","endra");
		System.out.println(result);

		obj.methodD(1,3);
		MyFunctionalInterface.staticMethod("lol");
	}
}
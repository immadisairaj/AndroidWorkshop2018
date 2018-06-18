public class Child extends Parent{
	
	@Override
	protected void methodA(){	//we can make less restricted only
		super.methodA();
		System.out.println("Overridden A");
	}

	/*@Override
	private void methodB(){
		//This cannot be done we will get error	
	}
	*/

	@Override
	public void methodB(){
		super.methodB();
		System.out.println("Overridden B");
	}

	public static void main(String[] args) {
		Child child = new Child();
		
		child.methodA();
		child.methodB();
	}
}
class Access{		//default class
	
	private A(){
		//private constructor
	}

	protected A(){
		//protected constructor
	}

	public A(){
		//public constructor
	}

	private class B{
		//private class (only nested)
	}

	protected class B{
		//protected class (only nested)
	}

	private int number;		//private
	String someString;		//default
	protected float num;	//protected
	public double numb;		//public

	protected void someMethod(){	//protected method
		System.out.println("HaHa");
	}
}
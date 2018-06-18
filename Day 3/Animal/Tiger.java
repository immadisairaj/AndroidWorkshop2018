public class Tiger extends Animal{
	
	@Override
	public void animalSays(){
		System.out.println("Roar !!");
	}

	public static void loll(){
		System.out.println("2");	//cannot override
	}

	/*@Override
	public static void lol(){
		//static overriding
	}*/
}
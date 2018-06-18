public class TigerCub extends Tiger{
	
	@Override
	public SomeChildClass animalSays(){		//Covariant return type
		System.out.println("Meow !");
		return new SomeChildClass();
	}
}
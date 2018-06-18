public class Tiger extends Animals{
	
	public void animalSays(){
		System.out.println("Meow !!");
	}

	//method overriding
	@Override
	public void printAnimal(){
		System.out.println("Tiger !!");
	}
}
public class Monkey extends Animals{
	
	public void animalSays(){
		System.out.println("Chatter");
	}

	//method overriding
	@Override
	public void printAnimal(){
		System.out.println("Monkey !");
	}
}
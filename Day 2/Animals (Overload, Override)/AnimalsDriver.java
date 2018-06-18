public class AnimalsDriver{
	public static void main(String args[]){

		Lion lion = new Lion();
		Tiger tiger = new Tiger();
		Monkey monkey = new Monkey();

		lion.animalSays();
		lion.printAnimal();
		System.out.println();

		tiger.animalSays();
		tiger.printAnimal();
		System.out.println();

		monkey.animalSays();
		monkey.printAnimal();
		System.out.println();
	}
}
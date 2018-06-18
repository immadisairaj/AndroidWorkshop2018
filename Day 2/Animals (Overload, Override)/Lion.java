public class Lion extends Animals{
	
	//method Overloading
	public void animalSays(){
		System.out.println("Roar !");
	}

	public void animalSays(String saySomething, int age){
		System.out.println(saySomething+" "+age);
	}

	public void animalSays(String saySomething, int age, boolean alive){
		System.out.println(saySomething+" "+age+" "+alive);
	}

	//method overriding
	@Override
	public void printAnimal(){
		System.out.println("Lion !");
	}

	public static void main(String[] args) {
		Lion lion = new Lion();

		//overriden method
		lion.printAnimal();

		//overloaded methods
		lion.animalSays("Yahooooo");
		lion.animalSays("I am old",50);
		lion.animalSays("Yayyyyyy",50,true);
	}
}
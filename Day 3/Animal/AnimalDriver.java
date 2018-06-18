public class AnimalDriver{
	
	public static void main(String[] args) {

		//String a;
		Animal a;

		a = new Animal();
		a.animalSays();
		a.loll();

		a = new Tiger();		//possible bcz of inheritence (it is child class)
		a.animalSays();
		a.loll();

		a = new TigerCub();
		a.animalSays();
		a.loll();

		Tiger b = new Tiger();
		b.loll();
		b = new TigerCub();
		b.loll();

		Animal.loll();
		Tiger.loll();
		TigerCub.loll();

		//Tiger tiger = new Animal();		//not allowed
	}
}
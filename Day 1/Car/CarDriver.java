public class CarDriver{
	public static void main(String args[]){
		Car car1 = new Car();
		Car car2 = new Car("Maruti",10000,"Red");
		Car car3 = new Car("Audi");
		car1.carDetails();
		car2.carDetails();
		car3.carDetails();
		car3.setColor("White");
		car3.setPrice(50000);
		car3.carDetails();
		String car2Color = car2.getColor();
		System.out.println(car2Color);
		System.out.println(car3.getDiscount(15)); 
	}
}

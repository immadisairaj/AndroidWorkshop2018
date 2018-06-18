public class Car{

	//data types
	private String brand;
	private int price;
	private String color;
	
	//constructors
	public Car(){
		//default constructor
	}

	public Car(String brand, int price, String color){
		this.brand=brand;
		this.price=price;
		this.color=color;
	}

	public Car(String brand){
		this.brand=brand;
	}

	//methods
	public String getBrand(){
		return this.brand;
	}

	public int getPrice(){
		return this.price;
	}

	public String getColor(){
		return this.color;
	}

	public void setBrand(String brand){
		this.brand=brand;
	}

	public void setPrice(int price){
		this.price=price;
	}

	public void setColor(String color){
		this.color=color;
	}

	public void setCar(String brand, int price, String color){
		this.brand=brand;
		this.price=price;
		this.color=color;
	}

	public float getDiscount(int discount){
		float cost = ((float) discount/100)*price;
		return price-cost;
	}

	public void carDetails(){
		System.out.println("The brand of Car is "+getBrand()+", Color is "+getColor()+" and Price is "+getPrice());
	}
}

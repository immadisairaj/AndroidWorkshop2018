public abstract class Shape{
	
	protected float area;
	protected float perimeter;
	
	abstract void setArea();
	abstract void setPerimeter();

	public void getArea(){
		System.out.println("The area is "+area);
	}

	public void getPerimeter(){
		System.out.println("The perimeter is "+perimeter);
	}
}
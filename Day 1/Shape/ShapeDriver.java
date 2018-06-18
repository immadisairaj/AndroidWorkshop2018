public class ShapeDriver{
	public static void main(String args[]){
		Circle c = new Circle(10);
		Square sq = new Square(10);
		Rectangle rc = new Rectangle(10,5);

		c.setArea();
		sq.setArea();
		rc.setArea();

		c.setPerimeter();
		sq.setPerimeter();
		rc.setPerimeter();

		c.getArea();
		sq.getArea();
		rc.getArea();

		c.getPerimeter();
		sq.getPerimeter();
		rc.getPerimeter();
	}
}
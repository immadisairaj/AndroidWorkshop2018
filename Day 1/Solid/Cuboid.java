public class Cuboid extends Solid{
	private float length;
	private float breadth;
	private float height;

	public Cuboid(){
		this.length=5;
		this.breadth=3;
		this.height=2;
	}

	public Cuboid(float length, float breadth, float height){
		this.length=length;
		this.breadth=breadth;
		this.height=height;
	}

	public void setVolume(){
		volume = length*breadth*height;
	}

	public void setTotalSurfaceArea(){
		totalSurfaceArea = 2*((length*breadth)+(breadth*height)+(height*length));
	}

	public void setLateralSurfaceArea(){
		lateralSurfaceArea = 2*height*(length+breadth);
	}
}
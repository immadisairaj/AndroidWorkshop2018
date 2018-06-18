public class Cube extends Solid{
	private float side;

	public Cube(){
		this.side=5;
	}

	public Cube(float side){
		this.side=side;
	}

	public void setVolume(){
		volume = side*side*side;
	}

	public void setTotalSurfaceArea(){
		totalSurfaceArea = 6*(side*side);
	}

	public void setLateralSurfaceArea(){
		lateralSurfaceArea = 4*(side*side);
	}
}
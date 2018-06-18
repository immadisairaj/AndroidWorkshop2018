public class Sphere extends Solid{
	private float radius;

	public Sphere(){
		this.radius=5;
	}

	public Sphere(float radius){
		this.radius=radius;
	}

	public void setVolume(){
		volume = (float) 4.18*(radius*radius*radius);
	}

	public void setTotalSurfaceArea(){
		totalSurfaceArea = (float) 12.56*(radius*radius);
	}

	public void setLateralSurfaceArea(){
		lateralSurfaceArea = (float) 12.56*(radius*radius);
	}
}
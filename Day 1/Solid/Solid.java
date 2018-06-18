public abstract class Solid{
	
	protected float volume;
	protected float totalSurfaceArea;
	protected float lateralSurfaceArea;
	
	abstract void setVolume();
	abstract void setTotalSurfaceArea();
	abstract void setLateralSurfaceArea();

	public void getVolume(){
		System.out.println("The volume is "+volume);
	}

	public void getTotalSurfaceArea(){
		System.out.println("The total surface area is "+totalSurfaceArea);
	}

	public void getLateralSurfaceArea(){
		System.out.println("The lateral surface area is "+lateralSurfaceArea);
	}
}
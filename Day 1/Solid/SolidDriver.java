public class SolidDriver{
	public static void main(String args[]){
		Sphere sp = new Sphere(10);
		Cube c = new Cube(10);
		Cuboid cb = new Cuboid(10,5,3);
		Cylinder cy = new Cylinder(10,3);

		sp.setVolume();
		sp.setTotalSurfaceArea();
		sp.setLateralSurfaceArea();
		sp.getVolume();
		sp.getTotalSurfaceArea();
		sp.getLateralSurfaceArea();

		c.setVolume();
		c.setTotalSurfaceArea();
		c.setLateralSurfaceArea();
		c.getVolume();
		c.getTotalSurfaceArea();
		c.getLateralSurfaceArea();

		cb.setVolume();
		cb.setTotalSurfaceArea();
		cb.setLateralSurfaceArea();
		cb.getVolume();
		cb.getTotalSurfaceArea();
		cb.getLateralSurfaceArea();

		cy.setVolume();
		cy.setTotalSurfaceArea();
		cy.setLateralSurfaceArea();
		cy.getVolume();
		cy.getTotalSurfaceArea();
		cy.getLateralSurfaceArea();
	}
}
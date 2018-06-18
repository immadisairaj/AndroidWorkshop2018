public class Car {
    
    String carName;
    int fuelCapacity;

    public Car (String carName, int fuelCapacity) {
        this.carName = carName;
        this.fuelCapacity = fuelCapacity;
    }

    public void drive (int distance) throws CarOutOfFuelException{
        if (fuelCapacity > 0 && fuelCapacity > distance) {
            System.out.println("Yayy, I am driving a "+carName);
        } else {
            throw new CarOutOfFuelException("No fuel :( ");
        }
        fuelCapacity -= distance;
    }
}
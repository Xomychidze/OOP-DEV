
public class Car extends AbstractVehicle {
    private int numDoors;

    public Car(String brand, int year, int numDoors) {
        super(brand, year);
        this.numDoors = numDoors;
    }

    @Override
    public void startEngine() {
        System.out.println(getBrand() + " car engine started — Vroom!");
    }

    @Override
    public double getFuelConsumption() {
        return 8.0;
    }

    public int getNumDoors() { return numDoors; }

    @Override
    public String toString() {
        return "Car[" + getBrand() + " " + getYear() + ", doors=" + numDoors + "]";
    }
}

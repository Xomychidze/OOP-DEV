
public class Plane extends AbstractVehicle implements Flyable {
    private int maxAltitude; // meters

    public Plane(String brand, int year, int maxAltitude) {
        super(brand, year);
        this.maxAltitude = maxAltitude;
    }

    @Override
    public void startEngine() {
        System.out.println(getBrand() + " turbines spinning up — whirrrr!");
    }

    @Override
    public double getFuelConsumption() { return 300.0; } // L/100km

    @Override
    public void fly() {
        System.out.println(getBrand() + " is flying at " + maxAltitude + "m altitude.");
    }

    @Override
    public int getMaxAltitude() { return maxAltitude; }

    @Override
    public String toString() {
        return "Plane[" + getBrand() + " " + getYear() + ", alt=" + maxAltitude + "m]";
    }
}

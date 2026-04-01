
public abstract class AbstractVehicle {
    private String brand;
    private int year;

    public AbstractVehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() { return brand; }
    public int getYear()     { return year; }

    // Every vehicle must implement these in its own way
    public abstract void startEngine();
    public abstract double getFuelConsumption(); // L/100km

    // Shared behavior — no need to repeat in subclasses
    public void displayInfo() {
        System.out.println("Brand: " + brand + " | Year: " + year
                + " | Fuel: " + getFuelConsumption() + " L/100km");
    }
}

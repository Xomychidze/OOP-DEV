
public class Bird implements Flyable {
    private String species;
    private int maxAltitude; // meters

    public Bird(String species, int maxAltitude) {
        this.species     = species;
        this.maxAltitude = maxAltitude;
    }

    @Override
    public void fly() {
        System.out.println(species + " flaps its wings and soars into the sky!");
    }

    @Override
    public int getMaxAltitude() {
        return maxAltitude;
    }

    @Override
    public String toString() {
        return "Bird[" + species + ", maxAlt=" + maxAltitude + "m]";
    }
}

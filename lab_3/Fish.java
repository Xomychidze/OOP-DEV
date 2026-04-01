
public class Fish implements Swimmable {
    private String name;
    private double speed;    // m/s
    private int    diveDepth; // meters

    public Fish(String name, double speed, int diveDepth) {
        this.name      = name;
        this.speed     = speed;
        this.diveDepth = diveDepth;
    }

    // --- From Moveable ---
    @Override
    public void move() {
        System.out.println(name + " glides silently through the water.");
    }

    @Override
    public double getSpeed() { return speed; }

    // --- From Swimmable ---
    @Override
    public void swim() {
        System.out.println(name + " swims at " + diveDepth + "m depth.");
    }

    @Override
    public int getDiveDepth() { return diveDepth; }

    @Override
    public String toString() {
        return "Fish[" + name + ", speed=" + speed + "m/s, depth=" + diveDepth + "m]";
    }
}

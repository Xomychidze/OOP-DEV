/**
 * TASK 2 — Robot implements Moveable directly (no swimming, no flying)
 */
public class Robot implements Moveable {
    private String name;
    private double speed; // m/s

    public Robot(String name, double speed) {
        this.name  = name;
        this.speed = speed;
    }

    @Override
    public void move() {
        System.out.println(name + " rolls forward at " + speed + " m/s. Beep boop!");
    }

    @Override
    public double getSpeed() { return speed; }

    @Override
    public String toString() { return "Robot[" + name + ", speed=" + speed + "]"; }
}

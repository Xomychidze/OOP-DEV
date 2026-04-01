
public class Duck implements Swimmable, Flyable {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    // --- From Moveable (via Swimmable) ---
    @Override
    public void move() {
        System.out.println(name + " waddles along the ground.");
    }

    @Override
    public double getSpeed() { return 2.5; }

    // --- From Swimmable ---
    @Override
    public void swim() {
        System.out.println(name + " paddles on the water surface.");
    }

    @Override
    public int getDiveDepth() { return 1; } // ducks don't dive deep

    // --- From Flyable ---
    @Override
    public void fly() {
        System.out.println(name + " flaps short wings and takes off! Quack!");
    }

    @Override
    public int getMaxAltitude() { return 100; }

    @Override
    public String toString() { return "Duck[" + name + "]"; }
}

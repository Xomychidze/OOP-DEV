public abstract class Shape3D {
    public abstract double volume();
    public abstract double surfaceArea();

    @Override
    public String toString() {
        return String.format("%s | Volume: %.2f | Surface Area: %.2f",
                getClass().getSimpleName(), volume(), surfaceArea());
    }
}

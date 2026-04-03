package task1;

// --- Abstract class ---
abstract class Shape {
    // Shared STATE — impossible in an interface
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() { return color; }

    // Abstract methods — subclasses MUST implement
    public abstract double area();
    public abstract double perimeter();

    // Template method: concrete, uses abstract methods
    public void describe() {
        System.out.printf("Shape: %-12s | Color: %-8s | Area: %7.2f | Perimeter: %7.2f%n",
                getClass().getSimpleName(), color, area(), perimeter());
    }
}

// --- Concrete subclasses ---
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override public double area()      { return Math.PI * radius * radius; }
    @Override public double perimeter() { return 2 * Math.PI * radius; }
}

class Rectangle extends Shape {
    private double width, height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override public double area()      { return width * height; }
    @Override public double perimeter() { return 2 * (width + height); }
}

class Triangle extends Shape {
    private double a, b, c;

    public Triangle(String color, double a, double b, double c) {
        super(color);
        this.a = a; this.b = b; this.c = c;
    }

    @Override public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    @Override public double perimeter() { return a + b + c; }
}

// --- Demo ---
public class AbstractClassExample {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle("Red",    5),
            new Rectangle("Blue", 4, 6),
            new Triangle("Green", 3, 4, 5)
        };

        System.out.println("=== Shape Report ===");
        for (Shape s : shapes) {
            s.describe();
        }
    }
}

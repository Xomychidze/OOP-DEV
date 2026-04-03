package task2;

import java.util.Scanner;

interface Moveable {
    void move(double dx, double dy);
    double getX();
    double getY();

    default String getPosition() {
        return String.format("(%.1f, %.1f)", getX(), getY());
    }
}

interface Flyable extends Moveable {
    void fly(double altitude);
    void land();
    double getAltitude();

    default boolean isAirborne() {
        return getAltitude() > 0;
    }

    void flyTo(double x, double y, double altitude);
}

class Car implements Moveable {
    private String model;
    private double x, y;

    public Car(String model, double x, double y) {
        this.model = model;
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
        System.out.println("Car moved to " + getPosition());
    }

    @Override public double getX() { return x; }
    @Override public double getY() { return y; }
}

class Drone implements Flyable {
    private String id;
    private double x, y, altitude;

    public Drone(String id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
        System.out.println("Drone moved to " + getPosition() + " altitude=" + altitude);
    }

    @Override
    public void fly(double altitude) {
        this.altitude = altitude;
        System.out.println("Drone altitude = " + altitude);
    }

    @Override
    public void flyTo(double tx, double ty, double altitude) {
        fly(altitude);
        move(tx - x, ty - y);
        System.out.println("Drone reached " + getPosition());
    }

    @Override
    public void land() {
        altitude = 0;
        System.out.println("Drone landed");
    }

    @Override public double getX() { return x; }
    @Override public double getY() { return y; }
    @Override public double getAltitude() { return altitude; }
}

class Airplane implements Flyable {
    private String flight;
    private double x, y, altitude;

    public Airplane(String flight) {
        this.flight = flight;
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
        System.out.println("Plane moved to " + getPosition() + " altitude=" + altitude);
    }

    @Override
    public void fly(double altitude) {
        this.altitude = altitude;
        System.out.println("Plane altitude = " + altitude);
    }

    @Override
    public void flyTo(double tx, double ty, double altitude) {
        fly(altitude);
        move(tx - x, ty - y);
        System.out.println("Plane reached " + getPosition());
    }

    @Override
    public void land() {
        altitude = 0;
        System.out.println("Plane landed");
    }

    @Override public double getX() { return x; }
    @Override public double getY() { return y; }
    @Override public double getAltitude() { return altitude; }
}

public class MoveableDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Moveable obj;

        System.out.println("Choose object: 1-Car, 2-Drone, 3-Airplane");
        int choice = sc.nextInt();

        if (choice == 1) obj = new Car("Tesla", 0, 0);
        else if (choice == 2) obj = new Drone("D1", 0, 0);
        else obj = new Airplane("KZ101");

        while (true) {
            System.out.println("\n1-Move | 2-FlyTo | 3-Land | 4-Status | 0-Exit");
            int cmd = sc.nextInt();

            if (cmd == 0) break;

            switch (cmd) {
                case 1:
                    System.out.print("dx dy: ");
                    double dx = sc.nextDouble();
                    double dy = sc.nextDouble();
                    obj.move(dx, dy);
                    break;

                case 2:
                    if (obj instanceof Flyable) {
                        Flyable f = (Flyable) obj;
                        System.out.print("targetX targetY altitude: ");
                        double x = sc.nextDouble();
                        double y = sc.nextDouble();
                        double alt = sc.nextDouble();
                        f.flyTo(x, y, alt);
                    } else {
                        System.out.println("This object cannot fly");
                    }
                    break;

                case 3:
                    if (obj instanceof Flyable) {
                        ((Flyable) obj).land();
                    } else {
                        System.out.println("No landing needed");
                    }
                    break;

                case 4:
                    System.out.println("Position: " + obj.getPosition());
                    if (obj instanceof Flyable) {
                        System.out.println("Altitude: " + ((Flyable) obj).getAltitude());
                    }
                    break;
            }
        }

        System.out.println("Exit");
    }
}
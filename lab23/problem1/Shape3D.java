package lab23.problem1;

public abstract class Shape3D {
    public abstract double volume();

    public abstract double surfaceArea();
}


class Cylinder extends Shape3D {
    private double radius;
    private double height;
    public Cylinder(double r, double h) {
    this.radius = r;
    this.height = h;
    }

    public void setRadius(double r){
        this.radius = r; 
    }
 
    public void setHeight(double h){
        this.height = h; 
    }

    public double getRadius(){
        return this.radius; 
    }
 
    public double getHeight(){
        return this.height; 
    }
    

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public double surfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    
}



class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    @Override
    public double surfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    public double getRadius() { return radius; }
}


class Cube extends Shape3D {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }

    @Override
    public double surfaceArea() {
        return 6 * side * side;
    }

    public double getSide() { return side; }
}
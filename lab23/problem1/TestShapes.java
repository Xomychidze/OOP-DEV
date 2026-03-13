package lab23.problem1;


public class TestShapes {
    public static void main(String[] args) {
        Shape3D[] shapes = {
            new Cylinder(3, 7),
            new Sphere(5),
            new Cube(4)
        };

        for (Shape3D shape : shapes) {
            if(shape instanceof Sphere){
                System.out.println(shape + " volume: " + shape.volume());
            }
            else if(shape instanceof Cylinder){
                System.out.println(shape + " volume: " + shape.volume());
            }
            else if(shape instanceof Cube){
                System.out.println(shape + " volume: " + shape.volume());
            }
        }
    }
}

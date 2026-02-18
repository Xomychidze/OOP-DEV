package lab4;

public class Dog extends Animal {

    private String breed; 
    private String size; 

    public Dog() {
        super();
    }


    public Dog(String name, int age, String sex, String breed, String size ) {
        super(name, age, sex);
        this.breed = breed; 
        this.size = size; 
    }

    
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    @Override
    public void eat(Food food){
        System.out.printf("this dog eat: %s", food.getName());
    }

    @Override
    public void eat(){
        System.out.println("Dogs not eats");
    }

    public String getBreed() {
        return breed;
    }

    public String getSize() {
        return size;
    }

    
}
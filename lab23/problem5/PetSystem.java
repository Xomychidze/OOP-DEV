package lab23.problem5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public abstract String getSound();

    @Override
    public String toString() {
        return String.format("%s('%s', age %d, says '%s')",
                getClass().getSimpleName(), name, age, getSound());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal a = (Animal) o;
        return age == a.age && Objects.equals(name, a.name) && getClass() == o.getClass();
    }

    @Override
    public int hashCode() { return Objects.hash(name, age, getClass()); }
}

class Cat extends Animal {
    public Cat(String name, int age) { super(name, age); }
    @Override public String getSound() { return "Meow"; }
}

class Dog extends Animal {
    public Dog(String name, int age) { super(name, age); }
    @Override public String getSound() { return "Woof"; }
}

class Bird extends Animal {
    public Bird(String name, int age) { super(name, age); }
    @Override public String getSound() { return "Tweet"; }
}

class Fish extends Animal {
    public Fish(String name, int age) { super(name, age); }
    @Override public String getSound() { return "...blub"; }
}

abstract class Person {
    private String name;
    private int age;
    private Animal pet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.pet = null;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public Animal getPet() { return pet; }
    public boolean hasPet() { return pet != null; }

    public abstract String getOccupation();

    public void assignPet(Animal pet) {
        this.pet = pet;
    }

    public void removePet() {
        this.pet = null;
    }

    public void leavePetWith(Person caretaker) {
        if (!hasPet()) {
            System.out.println("❌ " + name + " doesn't have a pet to leave.");
            return;
        }
        Animal myPet = this.pet;
        try {
            caretaker.assignPet(myPet);
            this.removePet();
            System.out.println("✅ " + name + " left " + myPet.getName()
                    + " with " + caretaker.getName() + ".");
        } catch (IllegalArgumentException ex) {
            System.out.println("❌ " + ex.getMessage());
        }
    }

    public void retrievePetFrom(Person caretaker) {
        if (caretaker.getPet() == null) {
            System.out.println("❌ " + caretaker.getName() + " doesn't have a pet to return.");
            return;
        }
        Animal theirPet = caretaker.getPet();
        this.assignPet(theirPet);
        caretaker.removePet();
        System.out.println("✅ " + name + " retrieved " + theirPet.getName()
                + " from " + caretaker.getName() + ".");
    }

    @Override
    public String toString() {
        String petInfo = hasPet() ? "🐾 " + pet : "no pet";
        return String.format("%-15s | %-10s | age %-3d | %s",
                name, getOccupation(), age, petInfo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return age == p.age && Objects.equals(name, p.name) && getClass() == o.getClass();
    }

    @Override
    public int hashCode() { return Objects.hash(name, age, getClass()); }
}

class Employee extends Person {
    private String position;

    public Employee(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    public String getPosition() { return position; }

    @Override
    public String getOccupation() { return "Employee"; }

    @Override
    public String toString() {
        return super.toString() + " [" + position + "]";
    }
}

class Student extends Person {
    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public String getMajor() { return major; }

    @Override
    public String getOccupation() { return "Student"; }

    @Override
    public String toString() {
        return super.toString() + " [" + major + "]";
    }
}

class PhDStudent extends Person {
    private String researchField;

    public PhDStudent(String name, int age, String major, String researchField) {
        super(name, age);
        this.researchField = researchField;
    }

    public String getResearchField() { return researchField; }

    @Override
    public String getOccupation() { return "PhD"; }

    @Override
    public void assignPet(Animal pet) {
        if (pet instanceof Dog) {
            throw new IllegalArgumentException(
                getName() + " is a PhD student and cannot take care of a Dog!");
        }
        super.assignPet(pet);
    }

    @Override
    public String toString() {
        return super.toString() + " [research: " + researchField + "]";
    }
}

class PersonRegistry {
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person p) {
        people.add(p);
        System.out.println("📋 Registered: " + p.getName());
    }

    public void removePerson(Person p) {
        people.remove(p);
        System.out.println("📋 Removed: " + p.getName());
    }

    public List<Person> findWithPets() {
        List<Person> result = new ArrayList<>();
        for (Person p : people) if (p.hasPet()) result.add(p);
        return result;
    }

    public List<Person> findWithoutPets() {
        List<Person> result = new ArrayList<>();
        for (Person p : people) if (!p.hasPet()) result.add(p);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔══════════════════════════════════════════════════════════════╗\n");
        sb.append("║                     PERSON REGISTRY                         ║\n");
        sb.append("╠══════════════════════════════════════════════════════════════╣\n");
        for (Person p : people)
            sb.append("║ ").append(p).append("\n");
        sb.append("╚══════════════════════════════════════════════════════════════╝\n");
        return sb.toString();
    }
}

public class PetSystem {
    public static void main(String[] args) {

        Person john  = new Employee("John", 30, "Engineer");
        Person alice = new PhDStudent("Alice", 26, "Comp. Science", "AI");
        Person bob   = new Student("Bob", 22, "Biology");
        Person sara  = new Employee("Sara", 35, "Manager");

        Animal rex   = new Dog("Rex", 3);
        Animal murka = new Cat("Murka", 5);
        Animal tweety = new Bird("Tweety", 2);
        Animal nemo  = new Fish("Nemo", 1);

        john.assignPet(rex);
        bob.assignPet(tweety);
        sara.assignPet(murka);

        System.out.println("\n── Assigning pets ──");
        try {
            alice.assignPet(new Dog("Buddy", 2));
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }

        alice.assignPet(nemo);

        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);
        registry.addPerson(bob);
        registry.addPerson(sara);

        System.out.println(registry);

        System.out.println("── John goes on vacation ──");
        john.leavePetWith(bob);
        System.out.println(registry);

        System.out.println("── Sara tries to leave Murka with Alice ──");
        sara.leavePetWith(alice);
        System.out.println(registry);

        System.out.println("── John returns from vacation ──");
        john.retrievePetFrom(bob);
        System.out.println(registry);

        System.out.println("── People without pets ──");
        for (Person p : registry.findWithoutPets())
            System.out.println("  " + p.getName());

        System.out.println("── People with pets ──");
        for (Person p : registry.findWithPets())
            System.out.println("  " + p.getName() + " → " + p.getPet());

        System.out.println("\n── Removing Bob from registry ──");
        registry.removePerson(bob);
        System.out.println(registry);
    }
}
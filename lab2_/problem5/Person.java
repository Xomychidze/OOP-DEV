import java.util.Objects;

public abstract class Person {
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

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    // Template method: subclasses may restrict which animals are allowed
    protected boolean canAcceptPet(Animal animal) {
        return true; // default: all animals allowed
    }

    public void assignPet(Animal animal) {
        if (!canAcceptPet(animal)) {
            System.out.printf("%s cannot accept a %s as a pet!%n",
                    getName(), animal.getClass().getSimpleName());
            return;
        }
        this.pet = animal;
    }

    public void removePet() {
        this.pet = null;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public abstract String getOccupation();

    // Person leaves their pet with another person temporarily
    public void leavePetWith(Person caretaker) {
        if (!hasPet()) {
            System.out.println(name + " has no pet to leave.");
            return;
        }
        Animal myPet = this.pet;
        if (!caretaker.canAcceptPet(myPet)) {
            System.out.printf("%s cannot take care of a %s!%n",
                    caretaker.getName(), myPet.getClass().getSimpleName());
            return;
        }
        caretaker.assignPet(myPet);
        this.removePet();
        System.out.printf("%s left %s with %s.%n", name, myPet.getName(), caretaker.getName());
    }

    // Person retrieves their pet from the caretaker
    public void retrievePetFrom(Person caretaker) {
        if (!caretaker.hasPet()) {
            System.out.println(caretaker.getName() + " has no pet to return.");
            return;
        }
        Animal theirPet = caretaker.getPet();
        caretaker.removePet();
        this.assignPet(theirPet);
        System.out.printf("%s retrieved %s from %s.%n", name, theirPet.getName(), caretaker.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        String petInfo = hasPet() ? "Pet: " + pet : "No pet";
        return String.format("%s [%s, age %d] - %s", name, getOccupation(), age, petInfo);
    }
}

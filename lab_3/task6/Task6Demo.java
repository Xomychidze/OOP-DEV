package task6;

interface Describable {
    String describe();

    default void printDescription() {
        System.out.println(describe());
    }
}

interface Trainable {
    void learn(String skill);
    String[] getLearnedSkills();

    default void showSkills() {
        String[] skills = getLearnedSkills();
        if (skills.length == 0) {
            System.out.println("No skills learned yet.");
        } else {
            System.out.println("Skills learned:");
            for (String s : skills) System.out.println("  - " + s);
        }
    }
}

class Person implements Comparable<Person>, Cloneable, Describable, Trainable {

    private String name;
    private int    age;
    private String[] skills;
    private int    skillCount;

    public Person(String name, int age) {
        this.name       = name;
        this.age        = age;
        this.skills     = new String[20];
        this.skillCount = 0;
    }

    public String getName() { return name; }
    public int    getAge()  { return age; }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public Person clone() {
        try {
            Person copy = (Person) super.clone();
            copy.skills = skills.clone();  // deep copy of skills array
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String describe() {
        return String.format("Person: %s, age %d, knows %d skill(s).", name, age, skillCount);
    }

    @Override
    public void learn(String skill) {
        if (skillCount < skills.length) {
            skills[skillCount++] = skill;
            System.out.println(name + " learned: " + skill);
        }
    }

    @Override
    public String[] getLearnedSkills() {
        String[] result = new String[skillCount];
        System.arraycopy(skills, 0, result, 0, skillCount);
        return result;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return age == p.age && name.equals(p.name);
    }
}

class Animal implements Comparable<Animal>, Cloneable, Describable, Trainable {

    private String name;
    private String species;   // e.g. "Dog", "Cat"
    private String owner;
    private String[] tricks;
    private int    trickCount;

    public Animal(String name, String species, String owner) {
        this.name       = name;
        this.species    = species;
        this.owner      = owner;
        this.tricks     = new String[10];
        this.trickCount = 0;
    }

    public String getName()    { return name; }
    public String getSpecies() { return species; }
    public String getOwner()   { return owner; }

    @Override
    public int compareTo(Animal other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public Animal clone() {
        try {
            Animal copy = (Animal) super.clone();
            copy.tricks = tricks.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String describe() {
        return String.format("Pet: %s (%s), owned by %s, knows %d trick(s).",
                name, species, owner, trickCount);
    }

    @Override
    public void learn(String trick) {
        if (trickCount < tricks.length) {
            tricks[trickCount++] = trick;
            System.out.println(name + " learned trick: " + trick);
        }
    }

    @Override
    public String[] getLearnedSkills() {
        String[] result = new String[trickCount];
        System.arraycopy(tricks, 0, result, 0, trickCount);
        return result;
    }

    @Override
    public String toString() {
        return "Animal{name='" + name + "', species='" + species + "', owner='" + owner + "'}";
    }
}

public class Task6Demo {
    public static void main(String[] args) {

        Person alice = new Person("Alice", 25);
        Person bob   = new Person("Bob",   30);
        Person carol = new Person("Carol", 22);

        alice.learn("Java");
        alice.learn("Python");
        bob.learn("Management");
        carol.learn("Kotlin");
        carol.learn("Spring Boot");
        carol.learn("Docker");

        System.out.println("=== Describable ===");
        alice.printDescription();
        bob.printDescription();
        carol.printDescription();

        System.out.println("\n=== Skills (Trainable) ===");
        alice.showSkills();

        System.out.println("\n=== Comparable (sort by age) ===");
        Person[] people = {alice, bob, carol};
        java.util.Arrays.sort(people);
        for (Person p : people) System.out.println(p.getName() + " -> age " + p.getAge());

        System.out.println("\n=== Clone ===");
        Person aliceClone = alice.clone();
        aliceClone.learn("Go");
        System.out.println("Original skills: " + alice.getLearnedSkills().length);  // 2
        System.out.println("Clone skills:    " + aliceClone.getLearnedSkills().length); // 3

        Animal rex   = new Animal("Rex",   "Dog", "Alice");
        Animal kitty = new Animal("Kitty", "Cat", "Bob");
        Animal bud   = new Animal("Bud",   "Dog", "Carol");

        rex.learn("Sit");
        rex.learn("Paw");
        rex.learn("Fetch");
        kitty.learn("High-five");
        bud.learn("Roll over");

        System.out.println("\n=== Animals (Describable) ===");
        rex.printDescription();
        kitty.printDescription();

        System.out.println("\n=== Animals (Comparable — sort by name) ===");
        Animal[] animals = {rex, kitty, bud};
        java.util.Arrays.sort(animals);
        for (Animal a : animals) System.out.println(a.getName() + " -> " + a.getSpecies());

        System.out.println("\n=== Pet tricks (Trainable) ===");
        rex.showSkills();

        // Polymorphism via custom interfaces
        System.out.println("\n=== Polymorphism via Describable ===");
        Describable[] describables = {alice, bob, rex, kitty};
        for (Describable d : describables) d.printDescription();
    }
}

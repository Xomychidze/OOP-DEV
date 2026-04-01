
public class Animal implements Comparable<Animal>, Cloneable, Describable, Identifiable {
    private String name;
    private String species;
    private int age;

    public Animal() {
        this("Unknown", "Unknown", 0);
    }

    public Animal(String name, String species, int age) {
        this.name    = name;
        this.species = species;
        this.age     = age;
    }

    // --- Getters / Setters ---
    public String getName()    { return name; }
    public String getSpecies() { return species; }
    public int getAge()        { return age; }
    public void setName(String name)       { this.name = name; }
    public void setSpecies(String species) { this.species = species; }
    public void setAge(int age)            { this.age = age; }

    // --- Object overrides ---
    @Override
    public String toString() {
        return "Animal[name=" + name + ", species=" + species + ", age=" + age + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Animal)) return false;
        Animal a = (Animal) obj;
        return name.equals(a.name) && species.equals(a.species);
    }

    // --- Comparable<Animal>: sort by name alphabetically ---
    @Override
    public int compareTo(Animal other) {
        return this.name.compareTo(other.name);
    }

    // --- Cloneable: shallow copy is enough here ---
    @Override
    public Animal clone() {
        try {
            return (Animal) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    // --- Describable ---
    @Override
    public String describe() {
        return "I am a " + species + " named " + name + ", " + age + " year(s) old.";
    }

    // --- Identifiable ---
    @Override
    public String getId() {
        return species + "_" + name;
    }
}

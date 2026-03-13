package lab23.problem1;
import java.util.Objects;

public class Pet extends Animal {
    private String ownerName;

    public Pet(String name, String species, String ownerName) {
        super(name, species);
        this.ownerName = ownerName;
    }

    public String getOwnerName() { return ownerName; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return super.equals(o) &&
               Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ownerName);
    }

    @Override
    public String toString() {
        return String.format("Pet[name=%s, species=%s, owner=%s]",
                getName(), getSpecies(), ownerName);
    }
}
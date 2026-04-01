
public class Chocolate implements Comparable<Chocolate> {
    private String name;
    private double weight; // grams

    public Chocolate(String name, double weight) {
        this.name   = name;
        this.weight = weight;
    }

    public String getName()   { return name; }
    public double getWeight() { return weight; }

    /** Compare by weight: lighter chocolate comes first */
    @Override
    public int compareTo(Chocolate other) {
        return Double.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return name + "(" + weight + "g)";
    }
}

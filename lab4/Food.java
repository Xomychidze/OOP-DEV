package lab4;



public class Food {

    private String name;
    private String type;
    private int shelfLife;

    public Food(String name, String type, int shelfLife) {
        this.name = name;
        this.type = type;
        this.shelfLife = shelfLife;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getShelfLife() {
        return shelfLife;
    }
}

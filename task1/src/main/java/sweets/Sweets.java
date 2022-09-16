package sweets;

public abstract class Sweets {
    public static int countSweets;
    public int price;
    public int weight;

    public Sweets() {
        countSweets++;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

}

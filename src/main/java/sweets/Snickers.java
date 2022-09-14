package sweets;

public class Snickers extends Sweets {
    public static int countSnickers;
    public static final int SnickersPrice = 3;
    public static final int SnickersWeight = 2;

    public Snickers() {
        this.price = SnickersPrice;
        this.weight = SnickersWeight;
        countSnickers++;
    }

}

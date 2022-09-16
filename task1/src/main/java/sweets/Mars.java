package sweets;

public class Mars extends Sweets {
    public static int countMars;
    public static final int MarsPrice = 2;
    public static final int MarsWeight = 3;

    public Mars() {
        this.price = MarsPrice;
        this.weight = MarsWeight;
        countMars++;
    }

}

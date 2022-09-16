package sweets;

public class Bounty extends Sweets {
    public static int countBounty;
    public static final int BountyPrice = 1;
    public static final int BountyWeight = 1;

    public Bounty() {
        this.price = BountyPrice;
        this.weight = BountyWeight;
        countBounty++;
    }

}

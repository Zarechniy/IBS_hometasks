package box;

import sweets.Bounty;
import sweets.Mars;
import sweets.Snickers;
import sweets.Sweets;

import java.util.ArrayList;

public class SweetsBox implements BoxInterface {

    public final int MaxBoxWeight = 10;
    ArrayList<Sweets> sweetsList = new ArrayList<>();

    @Override
    public void addSweets(Sweets sweets) {
        sweetsList.add(sweets);
    }

    @Override
    public void removeSweets(Sweets sweets) {
        if (sweets instanceof Snickers) {
            sweetsList.remove(sweets);
            Snickers.countSnickers--;
            Sweets.countSweets--;
        }
        else if (sweets instanceof Mars) {
            sweetsList.remove(sweets);
            Mars.countMars--;
            Sweets.countSweets--;
        }
        else if (sweets instanceof Bounty) {
            sweetsList.remove(sweets);
            Bounty.countBounty--;
            Sweets.countSweets--;
        }
    }

    @Override
    public String BoxWeight() {
        int BoxWeight = (Bounty.BountyWeight * Bounty.countBounty + Snickers.SnickersWeight * Snickers.countSnickers + Mars.MarsWeight * Mars.countMars);
        return "Total box weight is " + BoxWeight + " kilos";
    }

    @Override
    public int BoxWeightInt() {
        int BoxWeightInt;
        BoxWeightInt = (Bounty.BountyWeight * Bounty.countBounty + Snickers.SnickersWeight * Snickers.countSnickers + Mars.MarsWeight * Mars.countMars);
        return BoxWeightInt;
    }

    @Override
    public String BoxPrice() {
        int BoxPrice = (Bounty.BountyPrice * Bounty.countBounty + Snickers.SnickersPrice * Snickers.countSnickers + Mars.MarsPrice * Mars.countMars);
        return "Total box price is " + BoxPrice + " bucks";
    }

    @Override
    public void infoAboutSweets() {
        if (Sweets.countSweets > 0) {
            System.out.println("Total amount of all sweets is " + Sweets.countSweets);
        } else {
            System.out.println("There is nothing in the box");
        }

        if (Mars.countMars > 0) {
            System.out.println("Amount of Mars sweets is " + Mars.countMars + ". Weight is " + Mars.MarsWeight * Mars.countMars + ". Price is " + Mars.MarsPrice * Mars.countMars);
        } else {
            System.out.println("There are not any Mars sweets");
        }

        if (Snickers.countSnickers > 0) {
            System.out.println("Amount of Snickers sweets is " + Snickers.countSnickers + ". Weight is " + Snickers.SnickersWeight * Snickers.countSnickers + ". Price is " + Snickers.SnickersPrice * Snickers.countSnickers);
        } else {
            System.out.println("There are not any Snickers sweets");
        }

        if (Bounty.countBounty > 0) {
            System.out.println("Amount of Bounty sweets is " + Bounty.countBounty + ". Weight is " + Bounty.BountyWeight * Bounty.countBounty + ". Price is " + Bounty.BountyPrice * Bounty.countBounty);
        } else {
            System.out.println("There are not any Bounty sweets");
        }
    }

    @Override
    public Sweets findMinWeight() {
        Sweets minWeightSweet = null;
        for (int i = 0; i < sweetsList.size() - 1; i++) {
            if (sweetsList.get(i).getWeight() <= sweetsList.get(i + 1).getWeight()) {
                minWeightSweet = sweetsList.get(i);
            }
        }
        return minWeightSweet;
    }

    @Override
    public Sweets findMinPrice() {
        Sweets minPriceSweet = null;
        for (int i = 0; i < sweetsList.size() - 1; i++) {
            if (sweetsList.get(i).getPrice() <= sweetsList.get(i + 1).getPrice()) {
                minPriceSweet = sweetsList.get(i);
            }
        }
        return minPriceSweet;
    }

}


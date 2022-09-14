import box.SweetsBox;
import sweets.Bounty;
import sweets.Mars;
import sweets.Snickers;

public class Main {

    public static void main(String[] args) {

        SweetsBox box = new SweetsBox();
        box.addSweets(new Bounty());
        box.addSweets(new Mars());
        box.addSweets(new Snickers());
        box.addSweets(new Mars());
        box.addSweets(new Snickers());
        box.addSweets(new Bounty());

        //Условие удаления по весу
        while (box.BoxWeightInt() > box.MaxBoxWeight) {
            box.removeSweets(box.findMinWeight());
        }

//        //Условие удаления по цене
//        while (box.BoxWeightInt() > box.MaxBoxWeight) {
//            box.removeSweets(box.findMinPrice());
//        }

        System.out.println(box.BoxWeight());
        System.out.println(box.BoxPrice());
        box.infoAboutSweets();

        System.out.println("CONGRATULATIONS! WE'VE FOUND THE BEST SWEETBOX!");
    }
}

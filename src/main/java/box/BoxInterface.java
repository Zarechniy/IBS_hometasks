package box;
import sweets.Sweets;

public interface BoxInterface {

    default void addSweets(Sweets sweets) { }

    default void removeSweets(Sweets sweets) { }

    default String BoxWeight() {
        return null;
    }

    default int BoxWeightInt() {
      return 0;
    }

    default String BoxPrice() {
       return null;
    }

    default void infoAboutSweets() { }

    default Sweets findMinWeight() { return null; }

    default Sweets findMinPrice() { return null; }

}

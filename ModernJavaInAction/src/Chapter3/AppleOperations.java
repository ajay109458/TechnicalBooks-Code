package Chapter3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppleOperations {

    // Without lambda
    public static List<Apple> sortApplesByWeight(List<Apple> apples) {
        Comparator<Apple> comparator = new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.weight.compareTo(a2.weight);
            }
        };

        Collections.sort(apples, comparator);
        return apples;
    }

    public static List<Apple> sortApplesByPriceLambda(List<Apple> apples) {
        Comparator<Apple> phoneComparator = (Apple a1, Apple a2) -> a1.weight.compareTo(a2.weight);
        Collections.sort(apples, phoneComparator);
        return apples;
    }
}

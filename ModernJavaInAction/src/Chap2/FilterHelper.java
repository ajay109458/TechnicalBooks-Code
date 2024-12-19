package Chap2;

import java.util.ArrayList;
import java.util.List;

public class FilterHelper {

    // Method only filter the green apples
    public static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> filteredApples = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if (apple.color == Color.GREEN) {
                filteredApples.add(apple);
            }
        }

        return filteredApples;
    }

    // Filter apples of any color
    public static List<Apple> filterApples(List<Apple> apples, Color color) {
        List<Apple> filteredApples = new ArrayList<>();

        for (Apple apple : apples) {
            if (apple.color == color) {
                filteredApples.add(apple);
            }
        }

        return filteredApples;
    }

    // filter apple greater than a weight of 100 gm

    public static List<Apple> filterLighterApples(List<Apple> apples) {
        List<Apple> filteredApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.weight < 100) {
                filteredApples.add(apple);
            }
        }

        return filteredApples;
    }


    // Filter apples with predicates
    public static List<Apple> filterApples(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> filteredApples = new ArrayList<>();

        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                filteredApples.add(apple);
            }
        }

        return filteredApples;
    }


}

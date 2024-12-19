import Chap2.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static void validateChapter2() {
        List<Apple> allApples = new ArrayList<>();

        // Filter with instance of the class
        GreenApplePredicate predicate = new GreenApplePredicate();
        List<Apple> greenApples = FilterHelper.filterApples(allApples, predicate);

        // Filter with anonymous class
        greenApples = FilterHelper.filterApples(allApples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.color == Color.GREEN;
            }
        });

        // Filter with lambda class
        greenApples = FilterHelper.filterApples(allApples, apple -> apple.color == Color.GREEN);
    }
}
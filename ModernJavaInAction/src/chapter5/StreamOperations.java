package chapter5;

import java.util.ArrayList;
import java.util.List;

public class StreamOperations {

    public static List<Dish> getVegetarianDishesExternalIteration(List<Dish> dishes) {
        List<Dish> vegetarianDishes = new ArrayList<Dish>();

        for (Dish dish : dishes) {
            if (dish.isVegetarian()) {
                vegetarianDishes.add(dish);
            }
        }

        return vegetarianDishes;
    }

    public static List<Dish> getVegetarianDishes(List<Dish> dishes) {
        return dishes.stream()
                .filter(Dish::isVegetarian)
                .toList();
    }

    public static List<Integer> filterUniqueEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .distinct()
                .toList();
    }

    public static List<Dish> getHighCaloriesDishes(List<Dish> dishes) {
        return dishes.stream()
                .takeWhile(dish -> dish.getCalories() > 300)
                .toList();
    }

    public static List<Dish> get3Dishes(List<Dish> dishes) {
        return dishes.stream()
                .limit(3)
                .toList();
    }


}

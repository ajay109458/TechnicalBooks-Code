package Chapter4;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class StreamOperations {

    // Get name of low calories dishes in sorted order in Java 7
    public static List<String> getNameOfDishes(List<Dish> dishes) {
        List<String> names = new ArrayList<String>();

        List<Dish> lowCaloriesDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalories() < 400) {
                lowCaloriesDishes.add(dish);
            }
        }

        Collections.sort(lowCaloriesDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getCalories().compareTo(o2.getCalories());
            }
        });

        for(Dish dish : lowCaloriesDishes) {
            names.add(dish.getName());
        }

        return names;
    }

    public static List<String> getNameOfDishes1(List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .toList();
    }

    // Group dishes by type
    public static Map<String, List<Dish>> mapDishesByType(List<Dish> dishes) {
        return dishes.stream()
                .collect(groupingBy(Dish::getType));
    }


    // Get name of 3 dishes with high calories consumption
    public static List<String> get3HighCalories(List<Dish> dishes) {
        return dishes
                .stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
    }

    public static void differentIterationTypes(List<Dish> dishes) {

        // External Iteration
        List<String> names = new ArrayList<>();
        for(Dish dish : dishes) {
            names.add(dish.getName());
        }

        // External Iteration with Iterator
        Iterator<Dish> iterator = dishes.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            names.add(dish.getName());
        }

        // Iternal stream iterator
        names = dishes.stream()
                .map(Dish::getName)
                .collect(toList());

    }


}

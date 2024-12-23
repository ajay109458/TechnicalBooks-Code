package Chapter8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsHandsOn {
    public static void main(String[] args) {
        validateQuestion1();
        validateQuestion2();
        validateQuestion3();
        validateQuestion4();
        validateQuestion5();
        validateQuestion6();
        validateQuestion7();
        validateQuestion8();
        validateQuestion9();
    }

    public static void validateQuestion10() {
        List<Integer> inventory = IntStream.rangeClosed(1, 10).boxed().toList();
        inventory.spliterator();
    }

    public static void validateQuestion9() {
        List<String> grades = List.of("A", "B", "A", "C", "B", "A");
        Map<String, List<String>> map = grades.stream().collect(Collectors.groupingBy(String::toLowerCase));
        System.out.println(map);
    }

    public static void validateQuestion8() {
        Map<String, Integer> warehouse1 = new HashMap<>(Map.of("Apples", 50, "Oranges", 30));
        Map<String, Integer> warehouse2 = Map.of("Oranges", 20, "Bananas", 40);
        for(Map.Entry<String, Integer> entry : warehouse2.entrySet()) {
            warehouse1.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        System.out.println(warehouse1);
    }

    public static void validateQuestion1() {
        List<Double> prices = List.of(19.99, 49.99, 5.99, 12.99);
        prices.stream().forEach(System.out::println);
    }

    public static void validateQuestion2() {
        List<Integer> ages = new ArrayList<>(List.of(16, 21, 34, 12, 25, 15));
        ages.removeIf(age -> age < 18);
        System.out.println(ages);
    }

    public static void validateQuestion3() {
        List<Integer> scores = List.of(76, 89, 95, 88, 72);
        scores.stream().max(Integer::compareTo).ifPresent(System.out::println);
    }

    public static void validateQuestion4() {
        List<String> names = new ArrayList<>(List.of("john", "paul", "george", "ringo"));
        names.replaceAll(String::toUpperCase);
        System.out.println(names);
    }

    public static void validateQuestion5() {
        Map<String, Integer> followers = Map.of("user1", 100, "user2", 250);
        String username = "user3";
        int defaultFollowers = 0;

        int followersCount = followers.getOrDefault(username, defaultFollowers);
        System.out.println(followersCount);
    }

    public static void validateQuestion6() {
        Map<String, Double> discounts = new HashMap<>();
        String product = "Laptop";
        double defaultDiscount = 0.10;

        discounts.computeIfAbsent(product, k -> defaultDiscount);
        System.out.println(discounts);
    }

    public static void validateQuestion7() {
        List<Double> sales = IntStream.rangeClosed(1, 100).mapToDouble(i -> i * 10).boxed().toList();
        long totalValue = sales.parallelStream()
                .collect(Collectors.summingInt(Double::intValue));
        System.out.println(totalValue);
    }
}

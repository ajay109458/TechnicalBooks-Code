package Chapter3;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Chap3HandsOn {

    public static void validateQuestion1() {
        SumFunction sumFunction = (a, b) -> a + b;

        System.out.println(sumFunction.sum(10, 20));
    }

    public static void validateQuestion2() {
        List<Integer> numbers = List.of(10, 15, 20, 25, 30);
        List<Integer> result = numbers.stream()
                .dropWhile(num -> num % 2 != 0)
                .toList();
    }

    public static void validateQuestion3() {
        List<String> words = List.of("apple", "banana", "cherry", "date");
        words.sort(Comparator.reverseOrder());
    }

    public static void validateQuestion4() {
        Runnable runnable = () -> System.out.println("Hello");
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void validateQuestion5() {
        StringProcessor processor = input -> new StringBuilder(input.toUpperCase()).reverse().toString();
        String input = "functional programming";
        String result = processor.transform(input);
    }

    public static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(predicate)
                .toList();
    }

    public static void validateQuestion6() {
        Predicate<Integer> greaterThan50 = x -> x > 50;
        Predicate<Integer> divisibleBy5 = x -> x % 5 == 0;

        List<Integer> numbers = List.of(10, 45, 60, 23, 70, 88);

        // Greater than 50
        List<Integer> result1 = filterNumbers(numbers, greaterThan50);
        List<Integer> result2 = filterNumbers(numbers, divisibleBy5);
    }

    public static void validateQuestion7() {
        List<String> words = List.of("apple", "banana", "cherry");

        Function<String, Integer> lengthConverter = String::length;

        List<Integer> lengths = words.stream()
                .map(lengthConverter)
                .toList();
    }

    public static void validateQuestion8() {
        List<String> words = List.of("java", "lambda", "stream");
        Consumer<String> consumer = System.out::println;
        words.forEach(consumer);
    }

    public static void validateQuestion9() {
        BiFunction<Integer, Integer, String> biFunction = (x, y) -> Integer.toString(x + y);
        String result = biFunction.apply(1, 2);
    }

    public static void validateQuestion10() {
        Function<Integer, Integer> doubleFunction = num -> num * 2;
        Function<Integer, Integer> add5 = num -> num + 5;

        Function<Integer, Integer> combinedFucntion = doubleFunction.andThen(add5);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> result = numbers
                .stream()
                .map(combinedFucntion)
                .toList();
    }
}

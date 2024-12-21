package Chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chap4HandsOn {

    public static void validateQuestion1() {
        List<String> names = List.of("Alice", "Bob", "Annie", "Charlie");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .toList();

    }

    public static void validateQuestion2() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> result = numbers.stream()
                .map(num -> num * 2)
                .toList();
    }

    public static void validateQuestion3() {
        List<String> words = List.of("java", "stream", "lambda", "API");
        long count = words.stream()
                .filter(input -> input.length() > 4)
                .count();
    }

    public static void validateQuestion4() {
        int[] numbers = {10, 25, 30, 15};
        OptionalInt maxInt = Arrays.stream(numbers)
                .max();
        if (maxInt.isPresent()) {
            System.out.print(maxInt.getAsInt());
        }
    }

    public static void validateQuestion5() {
        List<String> words = List.of("banana", "apple", "cherry", "date");

        List<String> sortedWords = words.stream()
                .sorted()
                .toList();
    }

    public static void validateQuestion6() {
        IntStream.rangeClosed(1, 10)
                .limit(5)
                .forEach(System.out::println);
    }

    public static void validateQuestion7() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> result = numbers.stream()
                .distinct()
                .toList();
    }

    public static void validateQuestion8() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    public static void validateQuestion9() {
        // Print first 10 even numbers
        Stream.iterate(2, i -> i + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    public static void validateQuestion10() {
        List<String> names = List.of("Jack", "Jill", "John", "Alice");

        List<String> result = names.stream()
                .filter(name -> !name.startsWith("J"))
                .map(String::toUpperCase)
                .toList();

        System.out.println(result);
    }


}

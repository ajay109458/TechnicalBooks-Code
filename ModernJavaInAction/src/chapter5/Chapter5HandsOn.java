package chapter5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Chapter5HandsOn {

    public static void validateQuestion1() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> filteredEvenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .toList();
    }

    public static void validateQuestion2() {
        List<String> words = List.of("apple", "banana", "cherry");
        List<Integer> lengths = words.stream()
                .map(String::length)
                .toList();
    }

    public static void validateQuestion3() {
        List<Integer> numbers = List.of(5, 12, 18, 7, 3);

        Optional<Integer> optionalNumber = numbers.stream()
                .filter(num -> num > 10)
                .findFirst();

        if (optionalNumber.isPresent()) {
            System.out.println(optionalNumber.get());
        }
    }

    public static void validateQuestion4() {
        List<List<Integer>> nestedLists = List.of(List.of(1, 2), List.of(3, 4), List.of(5));

        List<Integer> streamNumbers = nestedLists.stream().flatMap(List::stream)
                .toList();
    }

    public static void validateQuestion5() {
        List<String> names = List.of("Charlie", "Alice", "Bob");

        List<String> results = names.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public static void validateQuestion6() {
        List<Integer> numbers = List.of(10, 25, 50, 120);

        boolean isAnyMatch = numbers.stream()
                .anyMatch(num -> num > 100);

        System.out.println("Is any number greater than 100 " + isAnyMatch);
    }

    // Check if all strings in the list starts with J
    public static void validateQuestion7() {
        List<String> names = List.of("Jack", "Jill", "John");
        boolean isAllMatch = names.stream()
                .allMatch(name -> name.startsWith("J"));
    }

    public static void validateQuestion8() throws IOException {
        String fileName = "sample.txt";
        List<String> lines = Files.lines(Path.of(fileName))
                .toList();
    }

    // Reduce to calculate the product
    public static void validateQuestion9() {
        List<Integer> numbers = List.of(1, 2, 3, 4);

        long product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(product);
    }

    public static void validateQuestion10() {
        List<String> words = List.of("apple", "fig", "banana", "date");

        List<String> sortedWords = words.stream()
                .sorted((a, b) -> Comparator.comparing(String::length).compare(a, b))
                .toList();
    }
}

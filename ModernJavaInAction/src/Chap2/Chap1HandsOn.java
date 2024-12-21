package Chap2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Chap1HandsOn {

    // Question 1 - Behavior Parameterization
    public static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> filteredNumbers = new ArrayList<>();

        for(Integer number : numbers) {
            if(predicate.test(number)) {
                filteredNumbers.add(number);
            }
        }

        return filteredNumbers;
    }

    public static void validateQuestion1() {
        List<Integer> numbers = List.of(10, 45, 60, 23, 70, 88);
        List<Integer> numbersGreaterThan50 = filterNumbers(numbers, new Predicate<Integer>() {
            @Override
            public boolean test(Integer num) {
                return num > 50;
            }
        });

        List<Integer> evenNumbers = filterNumbers(numbers, new Predicate<Integer>() {

            @Override
            public boolean test(Integer num) {
                return num % 2 == 0;
            }
        });
    }

    // Question 2 - Sort employee using lambda
    public void validateQuestion2() {
        List<Employee> employees = new ArrayList<>();

        // sort employee by age
        employees.sort(Comparator.comparing(e -> e.age));

        // sort employee by name
        employees.sort(Comparator.comparing(e -> e.name));
    }

    // Question 3 - Generic Predicate
    public static <T> List<T> filterList(List<T> inputList, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();

        for(T item : inputList) {
            if(predicate.test(item)) {
                filteredList.add(item);
            }
        }

        return filteredList;
    }

    public static void validateQuestion3() {
        List<String> words = List.of("apple", "banana", "cherry", "date");
        List<Integer> numbers = List.of(10, 45, 60, 23, 70, 88);

        // Filter string containing a
        List<String> filteredWords = filterList(words, input -> input.contains("a"));

        // Filter number less than 20
        List<Integer> filteredNumbers = filterList(numbers, input -> input < 20);
    }

    public static void validateQuestion4() {
        List<String> words = List.of("java", "lambda", "stream", "code");

        // upper case
        List<String> result1 = words.stream()
                .map(String::toUpperCase)
                .toList();

        // String length greater than five
        List<String> result2 = words.stream()
                .filter(Chap1HandsOn::isLengthGreaterThan5)
                .toList();
    }

    public static boolean isLengthGreaterThan5(String input) {
        return input.length() > 5;
    }

    public static void validateQuestion5() {
        List<Integer> numbers = List.of(5, 12, 20, 7, 15, 22, 6);

        Predicate<Integer> isEvenNumber = number -> number % 2 == 0;
        Predicate<Integer> greaterThan10 = number -> number > 10;

        Predicate<Integer> isEvenNumberAndGreaterThan10 = isEvenNumber.and(isEvenNumber);

        List<Integer> result = numbers.stream()
                .filter(isEvenNumberAndGreaterThan10)
                .toList();
    }

    public static void validateQuestion6() {
        StringTransformer stringTransformer = new StringTransformer() {
            @Override
            public String transform(String input) {
                StringBuilder buffer = new StringBuilder(input);
                buffer.reverse();
                return buffer.toString().toLowerCase();
            }
        };

        String input = "FunctionalProgramming";
        String result = stringTransformer.transform(input);
    }

    public static void validateQuestion7() {
        List<Integer> numbers = List.of(5, 12, 20, 7, 15, 22, 6);
        List<Integer> result = numbers.stream()
                .map(num -> num * num)
                .filter(num -> num > 100)
                .toList();
    }

    public static void validateQuestion8() {
        Logger logger = new Logger();

        logger.log(LogLevel.INFO, "This is a info message");
        logger.log(LogLevel.ERROR, "This is an error message");
        logger.log(LogLevel.WARN, "This is a warn message");
    }

    public static void validateQuestion9() {
        String filePath = "logs.txt";

        try {
            System.out.println("Lines containing errors");
            List<String> errorLines = processFileLines(filePath, line -> line.contains("error") ? line : null);
            errorLines.forEach(System.out::println);

            System.out.println("Lines in uppercase");
            List<String> uppercaseLines = processFileLines(filePath, String::toUpperCase);
            uppercaseLines.forEach(System.out::println);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static List<String> processFileLines(String filePath, Function<String, String> behavior) throws IOException {
        return Files.lines(Path.of(filePath))
                .map(behavior)
                .filter(Objects::nonNull)
                .toList();
    }


    public static List<Integer> applyFunction(List<Integer> numbers, Function<Integer, Integer> behavior)
    {
        return numbers.stream()
                .map(behavior)
                .toList();
    }

    public static void validateQuestion10() {
        List<Integer> numbers = List.of(10, 20, 30, 40);

        // Double all numbers
        List<Integer> doubleNumbers = applyFunction(numbers, num -> num * 2);

        // Subtract 10 from each number
        List<Integer> subtract10 = applyFunction(numbers, num -> num - 10);
    }


}

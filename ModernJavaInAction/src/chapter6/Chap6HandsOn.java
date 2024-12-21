package chapter6;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Chap6HandsOn {

    public static void validateQuestion1(){
        List<Integer> input = List.of(1, 2, 3, 4);
        List<Integer> result = input.stream()
                .toList();
    }

    public static void validateQuestion2(){
        List<String> fruits = List.of("apple", "banana", "cherry", "date");
        Map<Integer, List<String>> map = fruits.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    public static void validateQuestion3(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> map = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    public static void validateQuestion4(){
        List<String> input = List.of("Java", "Streams", "Collectors");
        String result = input.stream()
                .collect(Collectors.joining(", "));
    }

    public static void validateQuestion5(){
        List<Integer> numbers = List.of(10, 20, 30, 40);
        double average = numbers.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(average);
    }

    public static void validateQuestion6(){
        List<Integer> numbers = List.of(5, 10, 15);
        IntSummaryStatistics statistics = numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(statistics);
    }

    public static void validateQuestion7(){
        List<Integer> numbers = List.of(1, 2, 3, 2);
        numbers.stream().collect(Collectors.toUnmodifiableList());
    }

    public static void validateQuestion8(){
        List<Integer> numbers = List.of(1, 2, 3, 4);
        numbers.stream().collect(Collectors.reducing(0, (a, b) -> a + b));
    }

    public static void validateQuestion9(){
        List<String> fruits = List.of("apple", "banana", "apple", "cherry");
        Map<String, Long> countByName = fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void validateQuestion10(){
        List<String> inputList = List.of("Java", "Streams", "Collectors");
        Comparator<String> stringLengthComparator = Comparator.comparing(String::length);
        Optional<String> result = inputList.stream().collect(Collectors.maxBy(stringLengthComparator));
        if(result.isPresent()){
            System.out.println(result.get());
        }
    }
}

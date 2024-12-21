package chapter6;

import Chapter4.Dish;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingOperations {

    public static void GroupTransactionImperatively(List<Transaction> transactions) {
        Map<Currency, List<Transaction>> transactionsByCurrency = new HashMap<>();

        for(Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrency.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrency.put(currency, transactionsForCurrency);
            }

            transactionsForCurrency.add(transaction);
        }
    }

    public static void GroupTransactions(List<Transaction> transactions) {
        Map<Currency, List<Transaction>> transactionsByCurrency = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency));
    }

    public static long countDishes(List<Dish> dishes) {
        long count1 =  dishes.stream()
                .collect(Collectors.counting());

        long count2 = dishes.stream()
                .count();

        return count2;
    }

    public static void maxAndMin(List<Dish> dishes) {
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> maxCalorieDish = dishes.stream().collect(Collectors.maxBy(dishComparator));
    }

    public static void totalCalories(List<Dish> dishes) {
        long totalCalories = dishes.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("Total Calories: " + totalCalories);
    }

    public static void averageCalories(List<Dish> dishes) {
        double avgCalories = dishes.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("Average Calories: " + avgCalories);
    }

    public static void joinStrings(List<Dish> dishes) {
        String shortMenu = dishes.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(shortMenu);
    }

    public static void totalCaloriesWithReduction(List<Dish> dishes) {
        long totalCalories = dishes.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println("Total Calories: " + totalCalories);
    }

    public static void maxCalorieDishByReduction(List<Dish> dishes) {
        Optional<Dish> maxCaloriesDish = dishes.stream()
                .collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
    }

    public static void groupingByDishType(List<Dish> dishes) {
        Map<String, List<Dish>> dishesByType = dishes.stream()
                .collect(Collectors.groupingBy(Dish::getType));

        dishesByType = dishes.stream()
                .filter(dish -> dish.getCalories() > 500)
                .collect(Collectors.groupingBy(Dish::getType));

        /*dishesByType = dishes.stream()
                .collect(
                        Collectors.groupingBy(
                            Dish::getType,
                            Collectors.filtering(dish -> dish.getCalories() > 500),
                            Collectors.toList()
                        )
                );*/


         Map<String, List<String>> dishNamesByType = dishes.stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.mapping(Dish::getName, Collectors.toList())
                ));


    }

    public static void partitioningExamples(List<Dish> dishes) {
        Map<Boolean, List<Dish>> dishesPartition = dishes.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));

        List<Dish> vegetarianDishes = dishesPartition.get(true);
        vegetarianDishes = dishes.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
    }


}

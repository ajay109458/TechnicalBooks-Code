package Chap8Greedy;

import java.util.*;

public class Chap8HandsOn {
    public static void main(String[] args) {
        validateQuestion1();
        validateQuestion2();
        validateQuestion3();
    }

    public static void validateQuestion1() {
        int[] dominations = {1, 5, 10, 25};
        int amount = 63;

        int dominationIndex = dominations.length - 1;
        int coinCount = 0;
        while(amount > 0 && dominationIndex >= 0) {
            if (amount >= dominations[dominationIndex]) {
                coinCount += amount/dominations[dominationIndex];
                amount = amount % dominations[dominationIndex];
            } else {
                dominationIndex--;
            }
        }

        if (amount == 0) {
            System.out.println("Coin counts: " + coinCount);
        } else {
            System.out.println("Coin amount is not possible with given dominations");
        }
    }

    public static void validateQuestion2() {
        int capacity = 50;
        List<Item> items = new ArrayList<>();
        items.add(new Item(60, 10));
        items.add(new Item(100, 20));
        items.add(new Item(120, 30));

        Collections.sort(items, (a, b) -> Float.compare(a.price/ a.weight, b.price/ b.weight));

        List<Item> result = new ArrayList<>();
        for(Item item : items) {
            if (item.weight < capacity) {
                result.add(item);
                capacity -= item.weight;
            }
        }

        System.out.println(result);
    }

    public static void validateQuestion3() {
        Meeting[] meetings = new Meeting[]{new Meeting(1, 3), new Meeting(2, 5), new Meeting(4, 6), new Meeting(5, 7), new Meeting(8, 9)};

        Arrays.sort(meetings, Comparator.comparing(a -> a.end));
        int lastFinishedTime = meetings[0].end;

        List<Meeting> result = new ArrayList<>();

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i].start >= lastFinishedTime) {
                result.add(meetings[i]);
                lastFinishedTime = meetings[i].end;
            }
        }

        System.out.println(result);
    }
}

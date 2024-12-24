package Chap5Hashtable;

import java.util.HashMap;
import java.util.Map;

public class Chap5HandsOn {

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
        validateQuestion10();
    }

    public static void validateQuestion1() {
        BasicHashTable<String, Integer> hashTable = new BasicHashTable<>();

        hashTable.put("apple", 10);
        hashTable.put("orange", 20);

        System.out.println("Apple count is : " + hashTable.get("apple"));
        System.out.println("Orange count is : " + hashTable.get("orange"));
        System.out.println("Banana count is : " + hashTable.get("banana"));
    }

    public static void validateQuestion2() {
        HashTableWithChaining hashTableWithChaining = new HashTableWithChaining();

        int[] keys = {15, 25, 35, 45};

        for(int key : keys) {
            hashTableWithChaining.insert(key);
        }

        hashTableWithChaining.display();
    }

    public static void validateQuestion3() {
        HashTableWithLinearProbing hashTableWithLinearProbing = new HashTableWithLinearProbing();

        int[] keys = {15, 25, 35, 45};

        for(int key : keys) {
            hashTableWithLinearProbing.insert(key);
        }

        hashTableWithLinearProbing.display();
    }

    public static void validateQuestion4() {
        String input = "the cat sat on the mat";
        Map<String, Integer> map = new HashMap<>();

        for(String word : input.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println(map);
    }

    public static void validateQuestion5() {
        StringHashTable hashTable = new StringHashTable();

        hashTable.put("dog", 10);
        hashTable.put("cat", 20);
        hashTable.put("fish", 30);

        hashTable.display();

        System.out.print("Value for cat is : " + hashTable.get("cat"));
    }

    public static void validateQuestion6() {
        HashTableWithLoadFactor hashTableWithLoadFactor = new HashTableWithLoadFactor();

        int[] keys = {1, 2, 3, 4, 5, 6, 7};
        for(int key : keys) {
            hashTableWithLoadFactor.insert(key);
        }

        hashTableWithLoadFactor.display();
    }

    public static void validateQuestion7() {
        HashMap<String, Long> map = new HashMap<>();

        map.put("Alice", 123L);
        map.put("Bob", 456L);

        System.out.println(map);
    }

    public static void validateQuestion8() {
        HashTableHandleDuplicate hashTableHandleDuplicate = new HashTableHandleDuplicate();

        int[] keys = {10, 20, 10, 30};
        for(int key : keys) {
            hashTableHandleDuplicate.insert(key);
        }

        hashTableHandleDuplicate.display();
    }

    public static void validateQuestion9() {
        HashMap<Integer, Integer> cache = new HashMap<>();

        int[] keys = {5, 10, 15, 5};

        for(int key : keys) {
            System.out.println("Get Result for key : " + key + " : " + computeResult(key, cache));
        }
    }

    private static int computeResult(int key, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(key)) {
            System.out.print("Fetched from cache:");
            return cache.get(key);
        }

        System.out.print("Result Computed:");

        int calculateResult = key * key;
        cache.put(key, calculateResult);
        return calculateResult;
    }

    public static void validateQuestion10() {
        HashMap<String, Integer> table1 = new HashMap<>();
        HashMap<String, Integer> table2 = new HashMap<>();

        table1.put("a", 1);
        table1.put("b", 2);

        table2.put("b", 2);
        table2.put("a", 1);

        System.out.println(compareHashTables(table1, table2));
    }

    private static boolean compareHashTables(Map<String, Integer> hashTable1, Map<String, Integer> hashTable2) {
        if (hashTable1.size() != hashTable2.size()) {
            return false;
        }

        for(String key : hashTable1.keySet()) {
            if (!hashTable2.containsKey(key) || !hashTable1.get(key).equals(hashTable2.get(key))) {
                return false;
            }
        }

        return true;
    }

}

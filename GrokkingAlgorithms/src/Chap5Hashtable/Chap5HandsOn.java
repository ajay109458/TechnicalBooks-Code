package Chap5Hashtable;

public class Chap5HandsOn {

    public static void main(String[] args) {
        validateQuestion1();
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

    }

}

package Chap5Hashtable;

import java.util.LinkedList;

public class HashTableHandleDuplicate {
    public static final int TABLE_SIZE = 16;
    public LinkedList<Integer>[] table;

    public HashTableHandleDuplicate() {
        table = new LinkedList[TABLE_SIZE];

        for(int i = 0; i < TABLE_SIZE; ++i) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % TABLE_SIZE;
    }

    public void insert(int key) {
        int hash = hash(key);
        System.out.println(hash);
        table[hash].add(key); // Chaining in case of collision
    }

    public boolean exist(int key) {
        int hash = hash(key);
        if (table[hash] != null && table[hash].contains(key)) {
            return true;
        }

        return false;
    }

    public void display() {
        for(int i = 0; i < TABLE_SIZE; ++i) {
            System.out.print("Slot [" + i + "] has value: " + table[i] + "\n");
        }
    }

}

package Chap5Hashtable;

import java.util.LinkedList;

public class HashTableWithLinearProbing {
    public static final int TABLE_SIZE = 10;
    public Integer[] table;

    public HashTableWithLinearProbing() {
        table = new Integer[TABLE_SIZE];
    }

    private int hash(int key) {
        return key % TABLE_SIZE;
    }

    public void insert(int key) {
        int hashIndex = hash(key);
        while (table[hashIndex] != null) {
            hashIndex = (hashIndex + 1) % TABLE_SIZE;
        }

        table[hashIndex] = key;
    }

    public boolean exist(int key) {
        int hashIndex = hash(key);
        while(table[hashIndex] != null) {
            if(table[hashIndex] == key) {
                return true;
            }

            hashIndex = (hashIndex + 1) % TABLE_SIZE;
        }

        return false;
    }

    public void display() {
        for(int i = 0; i < TABLE_SIZE; ++i) {
            System.out.print("Slot [" + i + "] has value: " + table[i] + "\n");
        }
    }

}

package Chap5Hashtable;

import java.util.Arrays;
import java.util.Map;

public class StringHashTable {
    private static final int TABLE_SIZE = 10;
    private Entry[] table;

    private static class Entry {
        String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public StringHashTable() {
        table = new Entry[TABLE_SIZE];
        Arrays.fill(table, null);
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (31*hash + key.charAt(i)) % TABLE_SIZE;
        }
        return hash;
    }

    public void put(String key, int value) {
        int hash = hash(key);

        // Linear Probing
        if (table[hash] != null && !table[hash].key.equals(key)) {
            hash = (hash + 1) % TABLE_SIZE;
        }

        table[hash] = new Entry(key, value);
    }

    public Integer get(String key) {
        int hash = hash(key);
        while (table[hash] != null) {
            if (table[hash].key.equals(key)) {
                return table[hash].value;
            }

            hash = (hash + 1) % TABLE_SIZE;
        }

        return null;
    }

    public void display() {
        for(int i = 0; i < TABLE_SIZE; ++i) {
            System.out.print("Slot [" + i + "] has value: " + table[i] + "\n");
        }
    }
}

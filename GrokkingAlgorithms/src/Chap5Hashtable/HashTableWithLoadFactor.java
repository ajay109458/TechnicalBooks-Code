package Chap5Hashtable;

public class HashTableWithLoadFactor {
    private static int capacity = 4;
    private Integer[] table;
    private int size;
    private float loadFactor;

    public HashTableWithLoadFactor() {
        size = 0;
        loadFactor = 0.75f;
        table = new Integer[capacity];
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void insert(int key) {
        if (exceedAvailableCapacity()) {
            resizeHashTable();
        }

        int hashIndex = hash(key);
        while (table[hashIndex] != null) {
            hashIndex = (hashIndex + 1) % capacity;
        }

        table[hashIndex] = key;
        size++;

    }

    public boolean exceedAvailableCapacity() {
        if ((float) size / capacity > loadFactor) {
            return true;
        }

        return false;
    }

    private void resizeHashTable() {
        int currentTableSize = capacity;
        capacity = 2 * capacity;
        Integer[] temp = new Integer[capacity];
        for (int i = 0; i < currentTableSize; i++) {
            temp[i] = table[i];
        }
        table = temp;
    }

    public boolean exist(int key) {
        int hashIndex = hash(key);
        while(table[hashIndex] != null) {
            if(table[hashIndex] == key) {
                return true;
            }

            hashIndex = (hashIndex + 1) % capacity;
        }

        return false;
    }

    public void display() {
        for(int i = 0; i < capacity; ++i) {
            System.out.print("Slot [" + i + "] has value: " + table[i] + "\n");
        }
    }

}

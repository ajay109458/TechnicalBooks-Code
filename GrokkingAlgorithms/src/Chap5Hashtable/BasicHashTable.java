package Chap5Hashtable;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class BasicHashTable<K, V> {

    public static class Node<K, V> {
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node<K, V>>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public BasicHashTable() {
        table = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {
        int index = getHash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for(Node<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        table[index].add(new Node<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getHash(key);
        if (table[index] == null) {
            return null;
        }

        for(Node<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }

}

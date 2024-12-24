package Chap7Dijkstra;

public class Node<K> {
    public K name;
    public int weight;

    public Node(K name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}

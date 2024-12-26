package Chap8Greedy;

public class Edge<T> {
    T targetNode;
    int weight;

    public Edge(T targetNode, int weight) {
        this.targetNode = targetNode;
        this.weight = weight;
    }
}

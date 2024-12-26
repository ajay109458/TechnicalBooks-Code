package Chap8Greedy;

public class Edge<T> {
    T srcNode;
    T targetNode;
    int weight;

    public Edge(T targetNode) {
        this.targetNode = targetNode;
        this.weight = 0;
    }

    public Edge(T targetNode, int weight) {
        this.targetNode = targetNode;
        this.weight = weight;
    }

    public Edge(T srcNode, T targetNode, int weight) {
        this.srcNode = srcNode;
        this.targetNode = targetNode;
        this.weight = weight;
    }
}

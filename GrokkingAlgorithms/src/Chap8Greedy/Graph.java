package Chap8Greedy;

import java.util.*;

public class Graph<K> {

    Map<K, List<Edge<K>>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public Graph(List<K> nodes) {
        this();
        for (K node : nodes) {
            graph.put(node, new ArrayList<>());
        }
    }

    public void addEdge(K node1, K node2, int weight) {
        graph.get(node1).add(new Edge<>(node2, weight));
    }

    public void addEdges(K srcNode, List<Edge<K>> dstNodes) {
        graph.get(srcNode).addAll(dstNodes);
    }

    public List<Edge<K>> getNeighborsWithWeight(K node) {
        return graph.get(node);
    }

    public Set<K> getNodes() {
        return graph.keySet();
    }

}

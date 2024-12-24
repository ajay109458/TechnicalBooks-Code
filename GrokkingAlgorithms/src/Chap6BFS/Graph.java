package Chap6BFS;

import java.util.*;

public class Graph<K> {

    Map<K, List<K>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public Graph(List<K> nodes) {
        this();
        for (K node : nodes) {
            graph.put(node, new ArrayList<>());
        }
    }

    public void addEdge(K node1, K node2) {
        graph.get(node1).add(node2);
    }

    public void addEdges(K srcNode, List<K> dstNodes) {
        graph.get(srcNode).addAll(dstNodes);
    }

    public List<K> getNeighbors(K node) {
        return graph.get(node);
    }

    public Set<K> getNodes() {
        return graph.keySet();
    }

}

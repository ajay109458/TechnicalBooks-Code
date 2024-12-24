package Chap7Dijkstra;

import java.util.*;

public class Chap7HandsOn {

    public static void main(String[] args) {
        validateQuestion1();
    }

    public static void validateQuestion1() {
        Graph graph = new Graph(List.of('A', 'B', 'C', 'D'));
        graph.addEdge('A', 'B', 1);
        graph.addEdge('A', 'C', 4);
        graph.addEdge('B', 'C', 2);
        graph.addEdge('C', 'D', 1);
        graph.addEdge('B', 'D', 5);

        Map<Character, Integer> weights = findShortestPath(graph, 'A');
        System.out.println(weights);

    }

    private static Map<Character, Integer> findShortestPath(Graph<Character> graph, Character start) {
        Queue<Node<Character>> priorityQueue = new PriorityQueue<Node<Character>>(Comparator.comparingInt(a -> a.weight));
        Map<Character, Node> map = new HashMap<>();

        for(Character nodeName: graph.getNodes()) {
            Node<Character> node = new Node<>(nodeName, Integer.MAX_VALUE);
            priorityQueue.add(node);
            map.put(nodeName, node);
        }

        map.get(start).weight = 0;

        while(!priorityQueue.isEmpty()) {
            Node<Character> nodeWithMinWeight = priorityQueue.remove();
            for(Edge<Character> neighbourEdge : graph.getNeighborsWithWeight(nodeWithMinWeight.name)) {
                map.get(neighbourEdge.targetNode).weight = nodeWithMinWeight.weight + neighbourEdge.weight;
            }
        }

        Map<Character, Integer> result = new HashMap<>();
        for(Map.Entry<Character, Node> entry: map.entrySet()) {
            result.put(entry.getKey(), entry.getValue().weight);
        }

        return result;
    }


}

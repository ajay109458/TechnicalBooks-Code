package Chap7Dijkstra;

import java.util.*;

public class Chap7HandsOn {

    public static void main(String[] args) {
        validateQuestion1();
        validateQuestion2();
        validateQuestion3();
        validateQuestion4();
        validateQuestion5();
        validateQuestion6();
        validateQuestion7();
    }

    public static void validateQuestion1() {
        Graph<Character> graph = new Graph(List.of('A', 'B', 'C', 'D'));
        graph.addEdge('A', 'B', 1);
        graph.addEdge('A', 'C', 4);
        graph.addEdge('B', 'C', 2);
        graph.addEdge('C', 'D', 1);
        graph.addEdge('B', 'D', 5);

        Map<Character, Integer> weights = findShortestPath(graph, 'A');
        System.out.println(weights);

    }

    public static void validateQuestion2() {
        Graph<Integer> graph = new Graph(List.of(1, 2, 3, 4, 5));
        graph.addEdges(1, Arrays.asList(new Edge<>(2, 10), new Edge<>(3, 5)));
        graph.addEdges(2, Arrays.asList(new Edge<>(4, 1)));
        graph.addEdges(3, Arrays.asList(new Edge<>(2, 2), new Edge<>(4, 9), new Edge<>(5, 2)));
        graph.addEdges(4, Arrays.asList(new Edge<>(5, 4)));

        Map<Integer, Integer> weights = findShortestPath(graph, 1);
        System.out.println(weights);

    }

    public static void validateQuestion3() {
        // Graph as adjacency list
        Graph<Integer> graph = new Graph(List.of(1, 2, 3, 4, 5));
        // add edges
        Map<Integer, Integer> weights = findShortestPath(graph, 2);
        System.out.println(weights);
    }

    public static void validateQuestion4() {
        Graph<Character> graph = new Graph(List.of('A', 'B', 'C', 'D'));
        graph.addEdges('A', Arrays.asList(new Edge<>('B', 2), new Edge<>('D', 6)));
        graph.addEdges('B', Arrays.asList(new Edge<>('D', 3), new Edge<>('C', 1)));
        graph.addEdges('C', Arrays.asList(new Edge<>('D', 1)));

        printShorestPaths(graph, 'A', 'D');
    }

    public static void validateQuestion5() {
        Graph<Character> graph = new Graph(List.of('A', 'B', 'C', 'D'));
        graph.addEdges('A', Arrays.asList(new Edge<>('B', 5), new Edge<>('C', 10)));
        graph.addEdges('B', Arrays.asList(new Edge<>('D', 2)));
        graph.addEdges('C', Arrays.asList(new Edge<>('D', 3)));

        printShorestPaths(graph, 'A', 'D');
    }

    public static void validateQuestion6() {
        Map<Character, Map<Character, Integer>> mapOfShortestPath = new HashMap<>();

        Graph<Character> graph = new Graph(List.of('A', 'B', 'C', 'D'));

        // Add edges

        // for each node calculate the shortest Path
        for(Character nodeName : graph.getNodes()) {
            Map<Character, Integer> distances = findShortestPath(graph, nodeName);
            mapOfShortestPath.put(nodeName, distances);
        }
    }

    public static void validateQuestion7() {
        // Handled in findShortestPath.
    }



    public static <T> void printShorestPaths(Graph<T> graph, T start, T target) {
        Map<T, List<List<T>>> pathMap = new HashMap<>();
        Map<T, Integer> distances = findShortestPath(graph, start, pathMap);
        // Print all shortest paths
        System.out.println("Shortest paths from " + 'A' + " to " + 'D' + ":");
        for (List<T> path : pathMap.get(target)) {
            System.out.println(path);
        }
        System.out.println(distances);
    }

    private static <T> Map<T, Integer> findShortestPath(Graph<T> graph, T start) {
        Map<T, List<List<T>>> pathMap = new HashMap<>();

        // Check for negative weights
        for(T nodeName : graph.getNodes()) {
            List<Edge<T>> edges = graph.getNeighborsWithWeight(nodeName);
            for(Edge<T> edge : edges) {
                if (edge.weight < 0) {
                    throw new IllegalArgumentException("Edge " + edge.weight + " is negative");
                }
            }
        }

        return findShortestPath(graph, start, pathMap);
    }

    // Generic find Shortest Path
    private static <T> Map<T, Integer> findShortestPath(Graph<T> graph, T start, Map<T, List<List<T>>> pathMap) {
        Queue<Node<T>> priorityQueue = new PriorityQueue<Node<T>>(Comparator.comparingInt(a -> a.weight));
        Map<T, Node<T>> map = new HashMap<>();
        Set<T> visited = new HashSet<>();

        for(T nodeName: graph.getNodes()) {
            Node<T> node = new Node<>(nodeName, Integer.MAX_VALUE);
            priorityQueue.add(node);
            map.put(nodeName, node);
            pathMap.put(nodeName, new ArrayList<>());
        }

        map.get(start).weight = 0;
        pathMap.get(start).add(Collections.singletonList(start));

        while(!priorityQueue.isEmpty()) {
            Node<T> currNode = priorityQueue.remove();

            if (visited.contains(currNode.name)) {
                continue;
            }

            visited.add(currNode.name);

            for(Edge<T> neighbourEdge : graph.getNeighborsWithWeight(currNode.name)) {
                int currentWeight = map.get(neighbourEdge.targetNode).weight;
                int newDistance = currNode.weight + neighbourEdge.weight;
                if (newDistance < currentWeight) {
                    // Update the distance of the neighbour node
                    map.get(neighbourEdge.targetNode).weight = newDistance;

                    // update path
                    pathMap.put(neighbourEdge.targetNode, new ArrayList<>());
                    for(List<T> path: pathMap.get(currNode.name)) {
                        List<T> newPath = new ArrayList<>(path);
                        newPath.add(neighbourEdge.targetNode);
                        pathMap.get(neighbourEdge.targetNode).add(newPath);
                    }
                } else if (newDistance == currentWeight) {
                    for(List<T> path: pathMap.get(currNode.name)) {
                        List<T> newPath = new ArrayList<>(path);
                        newPath.add(neighbourEdge.targetNode);
                        pathMap.get(neighbourEdge.targetNode).add(newPath);
                    }
                }
            }
        }

        Map<T, Integer> result = new HashMap<>();
        for(Map.Entry<T, Node<T>> entry: map.entrySet()) {
            result.put(entry.getKey(), entry.getValue().weight);
        }

        return result;
    }


}

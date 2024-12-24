package Chap6BFS;

import java.util.*;

public class GraphHandsOn {
    public static void main(String[] args) {
        validateQuestion1();
        validateQuestion2();
        validateQuestion3();
        validateQuestion4();
        validateQuestion5();
        validateQuestion6();
        validateQuestion7();
        validateQuestion8();
        validateQuestion9();
        validateQuestion10();
    }

    public static void validateQuestion1() {
        Graph<Character> graph = new Graph<>(List.of('A', 'B', 'C', 'D'));
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');

        Set<Character> visited = new HashSet<>();
        bfs(graph, 'A', visited);
        System.out.println();
    }

    private static <T> void bfs(Graph<T> graph, T currentCh, Set<T> visited) {
        Queue<T> queue = new LinkedList<>();
        queue.add(currentCh);

        while (!queue.isEmpty()) {
            T ch = queue.remove();
            System.out.print(ch + " ");
            visited.add(ch);

            for (T childNodes : graph.getNeighbors(ch)) {
                if (!visited.contains(childNodes)) {
                    queue.add(childNodes);
                }
            }
        }
    }

    public static void validateQuestion2() {
        Graph<Character> graph = new Graph<>(List.of('A', 'B', 'C', 'D', 'E', 'F'));
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'E');
        graph.addEdge('D', 'F');
        graph.addEdge('E', 'F');

        List<Character> shortestPath = bfsShortestPath(graph, 'A', 'F');
        System.out.println("Shortest path is : " + shortestPath);
    }

    public static List<Character> bfsShortestPath(Graph<Character> graph, Character startCh, Character endCh) {

        // Queue stores path instead of a single node
        Queue<List<Character>> queue = new LinkedList<>();
        queue.add(Collections.singletonList(startCh));


        while (!queue.isEmpty()) {
            List<Character> path = queue.remove();
            Character currentNode = path.getLast();

            if (currentNode == endCh) {
                return path;
            }

            for (Character childNode : graph.getNeighbors(currentNode)) {
                if (!path.contains(childNode)) {
                    List<Character> newPath = new ArrayList<>(path);
                    newPath.add(childNode);
                    queue.add(newPath);
                }
            }
        }

        return Collections.emptyList();
    }

    public static void validateQuestion3() {
        Graph graph = new Graph(List.of('A', 'B', 'C', 'D', 'E', 'F'));
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('D', 'A');

        System.out.println("Has Cycle: " + hasCycleViaBFS(graph, 'A'));
    }

    public static boolean hasCycleViaBFS(Graph<Character> graph, Character currentCh) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(currentCh);
        Set<Character> visited = new HashSet<>();
        visited.add(currentCh);

        while (!queue.isEmpty()) {
            Character ch = queue.remove();
            System.out.print(ch + " ");

            for (Character childNode : graph.getNeighbors(ch)) {
                if (visited.contains(childNode)) {
                    return true;
                }

                queue.add(childNode);
            }
        }

        return false;
    }

    public static void validateQuestion4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        levelOrder(root);
    }

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                System.out.print(node.val + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                    System.out.println();
                }
            }
        }
    }

    public static void validateQuestion5() {
        Graph<Integer> graph = new Graph<>(List.of(1, 2, 3, 4));
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        System.out.println();
        System.out.println("Connected component count is : " + countConnectedComponents(graph));
    }

    private static int countConnectedComponents(Graph<Integer> graph) {
        Set<Integer> visited = new HashSet<>();
        int connectedComponents = 0;

        for(Integer node : graph.getNodes()) {
            if (!visited.contains(node)) {
                bfs(graph, node, visited);
                connectedComponents++;
            }
        }

        return connectedComponents;
    }

    public static void validateQuestion6() {
        int n = 7;
        int[][] adjMatrix = new int[n][n];

        Graph<Integer> graph = new Graph<>(List.of(0, 1, 2, 3, 4, 5, 6));

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (adjMatrix[i][j] == 1) {
                    graph.addEdge(i, j);
                }
            }
        }
    }

    public static void validateQuestion7() {
        Graph<Character> graph = new Graph<>(List.of('A', 'B', 'C', 'D', 'E', 'F'));
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');

        Map<Character, Integer> distanceMap = bfsShortestPath(graph, 'A');
        System.out.println(distanceMap);
    }

    private static Map<Character, Integer> bfsShortestPath(Graph<Character> graph, Character srcCh) {
        Map<Character, Integer> shortestPath = new HashMap<>();

        // All nodes are at the infinite distance
        for(Character ch : graph.getNodes()) {
            shortestPath.put(ch, Integer.MAX_VALUE);
        }

        Queue<Character> queue = new LinkedList<>();
        queue.add(srcCh);

        // Source node is at the zero distance
        shortestPath.put(srcCh, 0);

        while (!queue.isEmpty()) {
            Character ch = queue.remove();

            for(Character neighbour : graph.getNeighbors(ch)) {
                queue.add(neighbour);
                shortestPath.put(neighbour, shortestPath.get(ch) + 1);
            }
        }

        return shortestPath;
    }

    public static void validateQuestion8() {
        Graph graph = new Graph(List.of('A', 'B', 'C', 'D', 'E', 'F'));
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'E');
        graph.addEdge('D', 'F');
        graph.addEdge('E', 'F');

        Map<Character, Integer> distanceMap = bfsWithWeights(graph, 'A');
        System.out.println(distanceMap);
    }

    // Treat all weights are same
    public static Map<Character, Integer> bfsWithWeights(Graph<Character> graph, Character srcCh) {
        Map<Character, Integer> distances = new HashMap<>();

        for(Character node : graph.getNodes()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        Queue<Character> queue = new LinkedList<>();
        queue.add(srcCh);
        distances.put(srcCh, 0);

        while (!queue.isEmpty()) {
            Character currNode = queue.remove();
            Integer currDistance = distances.get(currNode);

            for(Character neighbour : graph.getNeighbors(currNode)) {
                // Neighbour is not yet visited
                if (distances.get(neighbour) == Integer.MAX_VALUE) {
                    distances.put(neighbour, currDistance + 1);
                    queue.add(neighbour);
                }
            }
        }

        return distances;
    }

    public static void validateQuestion9() {
        Graph graph = new Graph(List.of('A', 'B', 'C', 'D', 'E', 'F'));
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'C');
        graph.addEdge('C', 'D');
        graph.addEdge('E', 'F');

        printBFS(graph, 'A');
    }

    private static void printBFS(Graph<Character> graph, Character srcCh) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(srcCh);

        while(!queue.isEmpty()) {
            Character ch = queue.remove();
            System.out.print("Current Character : " + ch + " and Queue: "  + queue);

            for(Character neighbour : graph.getNeighbors(ch)) {
                queue.add(neighbour);
            }
        }
    }

    private static void validateQuestion10() {
        Graph<String> graph = new Graph<>(List.of("Alice", "Bob", "Charlie", "David", "Eve", "Frank"));
        graph.addEdges("Alice", Arrays.asList("Bob", "Charlie"));
        graph.addEdges("Bob", Arrays.asList("Alice", "David", "Eve"));
        graph.addEdges("Charlie", Arrays.asList("Alice", "Eve"));
        graph.addEdges("David", Arrays.asList("Bob", "Frank"));
        graph.addEdges("Eve", Arrays.asList("Bob", "Charlie", "Frank"));
        graph.addEdges("Frank", Arrays.asList("David", "Eve"));

        System.out.println();
        List<String> shortestPath = shortestConnectionSocialNetwork(graph, "Alice", "Frank");
        System.out.println("Shortest Path : " + shortestPath);
    }

    public static List<String> shortestConnectionSocialNetwork(Graph<String> graph, String srcUser, String endUser) {

        if (!graph.getNodes().contains(srcUser) || !graph.getNodes().contains(endUser)) {
            throw new IllegalArgumentException("Both users should be present in the network");
        }

        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(Collections.singletonList(srcUser));
        visited.add(srcUser);

        while (!queue.isEmpty()) {
            List<String> path = queue.remove();
            String currentUser = path.getLast();

            // We reach the end user now return the path
            if (currentUser.equals(endUser)) {
                return path;
            }

            for (String friendUser : graph.getNeighbors(currentUser)) {
                if (!path.contains(friendUser)) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(friendUser);
                    queue.add(newPath);
                }
            }
        }

        return Collections.emptyList();
    }
}


package Chap8Greedy;

import java.util.*;

public class Chap8HandsOn {
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
        int[] dominations = {1, 5, 10, 25};
        int amount = 63;

        int dominationIndex = dominations.length - 1;
        int coinCount = 0;
        while(amount > 0 && dominationIndex >= 0) {
            if (amount >= dominations[dominationIndex]) {
                coinCount += amount/dominations[dominationIndex];
                amount = amount % dominations[dominationIndex];
            } else {
                dominationIndex--;
            }
        }

        if (amount == 0) {
            System.out.println("Coin counts: " + coinCount);
        } else {
            System.out.println("Coin amount is not possible with given dominations");
        }
    }

    public static void validateQuestion2() {
        int capacity = 50;
        List<Item> items = new ArrayList<>();
        items.add(new Item(60, 10));
        items.add(new Item(100, 20));
        items.add(new Item(120, 30));

        Collections.sort(items, (a, b) -> Float.compare(a.price/ a.weight, b.price/ b.weight));

        List<Item> result = new ArrayList<>();
        for(Item item : items) {
            if (item.weight < capacity) {
                result.add(item);
                capacity -= item.weight;
            }
        }

        System.out.println(result);
    }

    public static void validateQuestion3() {
        Meeting[] meetings = new Meeting[]{new Meeting(1, 3), new Meeting(2, 5), new Meeting(4, 6), new Meeting(5, 7), new Meeting(8, 9)};

        Arrays.sort(meetings, Comparator.comparing(a -> a.end));
        int lastFinishedTime = meetings[0].end;

        List<Meeting> result = new ArrayList<>();

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i].start >= lastFinishedTime) {
                result.add(meetings[i]);
                lastFinishedTime = meetings[i].end;
            }
        }

        System.out.println(result);
    }


    // Huffman Encoding
    public static void validateQuestion4() {
        Map<Character, Integer> frequencies = new HashMap<>();
        frequencies.put('A', 5);
        frequencies.put('B', 9);
        frequencies.put('C', 12);
        frequencies.put('D', 13);
        frequencies.put('E', 16);
        frequencies.put('F', 45);

        Map<Character, String> result = huffmanEncoding(frequencies);
        // Display the Huffman codes
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<Character, String> huffmanEncoding(Map<Character, Integer> frequencies) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new HuffmanEncoding.NodeComparator());

        for (Map.Entry<Character, Integer> entry: frequencies.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode newNode = new HuffmanNode('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        HuffmanNode root = pq.poll();
        Map<Character, String> result = HuffmanEncoding.generateHuffmanCodes(root);
        return result;
    }

    // Job Sequencing Problem
    public static void validateQuestion5() {
        Job[] jobs = {
           new Job(1, 2, 100),
           new Job(2, 1, 19),
           new Job(3, 2, 20),
           new Job(4, 1, 25),
           new Job(5, 3, 15),
        };

        int maxDeadline = Arrays.stream(jobs).mapToInt(job -> job.deadline).max().orElse(0);

        jobScheduling(jobs, maxDeadline);
    }

    public static int jobScheduling(Job[] jobs, int maxDeadline) {
        Arrays.sort(jobs, Comparator.comparing(a -> a.profit));

        boolean[] slots = new boolean[maxDeadline];
        int[] result = new int[maxDeadline];

        int totalProfit = 0;

        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline - 1, job.deadline - 1); j >= 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    result[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        // Print the selected jobs and the total profit
        System.out.println("Selected Jobs:");
        for (int i = 0; i < maxDeadline; i++) {
            if (slots[i]) {
                System.out.print("Job " + result[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);

        return totalProfit;
    }

    public static void validateQuestion6() {
        Graph<Character> graph = new Graph<>(List.of('A', 'B', 'C', 'D'));
        graph.addEdges('A', Arrays.asList(new Edge<>('B', 2), new Edge<>('C', 3)));
        graph.addEdges('B', Arrays.asList(new Edge<>('A', 2), new Edge<>('C', 1), new Edge<>('D', 4)));
        graph.addEdges('C', Arrays.asList(new Edge<>('A', 3), new Edge<>('B', 1), new Edge<>('D', 5)));
        graph.addEdges('D', Arrays.asList(new Edge<>('B', 4), new Edge<>('C', 5)));

        primMST(graph, 'A');
    }

    public static void primMST(Graph<Character> graph, Character startNodeName) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<Character> visited = new HashSet<>();
        List<Character> mstEdges = new ArrayList<>();

        visited.add(startNodeName);

        for(Edge edge : graph.getNeighborsWithWeight(startNodeName)) {
            priorityQueue.offer(edge);
        }

        int totalWeight = 0;

        while(!priorityQueue.isEmpty()) {
            Edge<Character> currentEdge = priorityQueue.poll();

            if (visited.contains(currentEdge.targetNode)) {
                continue;
            }

            // Add the edge to the MST
            visited.add(currentEdge.targetNode);
            mstEdges.add(currentEdge.targetNode);
            totalWeight += currentEdge.weight;

            // Add all neighbours
            for(Edge edge : graph.getNeighborsWithWeight(currentEdge.targetNode)) {
                if (!visited.contains(edge.targetNode)) {
                    priorityQueue.offer(edge);
                }
            }
        }

        System.out.println("Minimum Spanning Tree: " + mstEdges);
        System.out.println("Total Weight: " + totalWeight);
    }

    public static List<Edge> kruskalMST(List<Edge> edges, Set<Character> nodes) {
        List<Edge> mstEdges = new ArrayList<>();
        UnionFind uf = new UnionFind();

        for(Character node: nodes) {
            uf.makeSet(node);
        }

        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        for(Edge<Character> edge : edges) {
            if (uf.union(edge.srcNode, edge.targetNode)) {
                mstEdges.add(edge);
            }
        }

        return mstEdges;
    }

    public static void validateQuestion7() {
        Graph<Character> graph = new Graph<>(List.of('A', 'B', 'C', 'D'));
        graph.addEdge('A', 'B', 4);
        graph.addEdge('A', 'C', 3);
        graph.addEdge('B', 'D', 2);
        graph.addEdge('C', 'D', 1);


    }

    public static void validateQuestion8() {
        Graph<Character> graph = new Graph<>(List.of('A', 'B', 'C', 'D', 'E'));
        graph.addEdges('A', Arrays.asList(new Edge<>('B'), new Edge<>('C')));
        graph.addEdges('B', Arrays.asList(new Edge<>('A'), new Edge<>('C')));
        graph.addEdges('C', Arrays.asList(new Edge<>('A'), new Edge<>('B'), new Edge<>('D')));
        graph.addEdges('D', Arrays.asList(new Edge<>('C'), new Edge<>('E')));
        graph.addEdges('E', Arrays.asList(new Edge<>('D')));

        Map<Character, Integer> colorAssignment = greedyColoring(graph);

        // Display results
        System.out.println("Vertex Coloring:");
        for (Map.Entry<Character, Integer> entry : colorAssignment.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + ": Color " + entry.getValue());
        }

        // Calculate and display the total number of colors used
        int numColors = new HashSet<>(colorAssignment.values()).size();
        System.out.println("Total Colors Used: " + numColors);
    }

    private static Map<Character, Integer> greedyColoring(Graph<Character> graph) {
        Map<Character, Integer> colorAssignment = new HashMap<>();

        for(Character nodeName : graph.getNodes()) {
            Set<Integer> adjacentColors = new HashSet<>();
            for(Edge<Character> edge: graph.getNeighborsWithWeight(nodeName)) {
                Character neighbour = edge.targetNode;
                if (colorAssignment.containsKey(neighbour)) {
                    adjacentColors.add(colorAssignment.get(neighbour));
                }
            }

            int color = 0;
            while(adjacentColors.contains(color)) {
                color++;
            }

            colorAssignment.put(nodeName, color);
        }

        return colorAssignment;
    }

    public static void validateQuestion9() {
        int[] dominations = {1, 2, 5, 10};
        int amount = 17;

        int dominationIndex = dominations.length - 1;
        int coinCount = 0;
        while(amount > 0 && dominationIndex >= 0) {
            if (amount >= dominations[dominationIndex]) {
                coinCount += amount/dominations[dominationIndex];
                amount = amount % dominations[dominationIndex];
            } else {
                dominationIndex--;
            }
        }

        if (amount == 0) {
            System.out.println("Coin counts: " + coinCount);
        } else {
            System.out.println("Coin amount is not possible with given dominations");
        }
    }

    public static void validateQuestion10() {
        Map<Character, Integer> frequencies = new HashMap<>();
        frequencies.put('A', 5);
        frequencies.put('B', 9);
        frequencies.put('C', 12);
        frequencies.put('D', 13);
        frequencies.put('E', 16);
        frequencies.put('F', 45);

        Map<Character, String> result = huffmanEncoding(frequencies);
        // Display the Huffman codes
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

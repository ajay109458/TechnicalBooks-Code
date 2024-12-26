package Chap8Greedy;

import java.util.*;

public class Chap8HandsOn {
    public static void main(String[] args) {
        validateQuestion1();
        validateQuestion2();
        validateQuestion3();
        validateQuestion4();
        validateQuestion5();
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

    // Job Sequencing Problem
    public static void validateQuestion4() {
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

    public static void validateQuestion5() {
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


}

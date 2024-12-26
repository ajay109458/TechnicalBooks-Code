package Chap8Greedy;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    private Map<Character, Character> parent = new HashMap<>();
    private Map<Character, Integer> rank = new HashMap<>();

    public void makeSet(Character nodeName) {
        parent.put(nodeName, nodeName);
        rank.put(nodeName, 0);
    }

    public Character find(Character nodeName) {
        if (!parent.get(nodeName).equals(nodeName)) {
            parent.put(nodeName, find(parent.get(nodeName)));
        }

        return parent.get(nodeName);
    }

    public boolean union(Character node1, Character node2) {
        Character root1 = find(node1);
        Character root2 = find(node2);

        if (root1.equals(root2)) {
            return false;
        }

        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else if (rank.get(root2) > rank.get(root1)) {
            parent.put(root1, root2);
        } else {
            parent.put(root2, root1);
            rank.put(root1, rank.get(root1) + 1);
        }

        return true;
    }

}

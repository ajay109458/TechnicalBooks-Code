package Chap8Greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoding {
    public static class NodeComparator implements Comparator<HuffmanNode> {

        @Override
        public int compare(HuffmanNode o1, HuffmanNode o2) {
            return o1.freq - o2.freq;
        }
    }

    public static Map<Character, String> generateHuffmanCodes(HuffmanNode root) {
        Map<Character, String> codes = new HashMap<>();
        encode(root, "", codes);
        return codes;
    }

    private static void encode(HuffmanNode node, String code, Map<Character, String> huffmanCodes)
    {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.ch, code);
        }

        encode(node.left, code + "0", huffmanCodes);
        encode(node.right, code + "1", huffmanCodes);
    }
}

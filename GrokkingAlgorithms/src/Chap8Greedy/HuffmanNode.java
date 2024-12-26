package Chap8Greedy;

public class HuffmanNode {
    Character ch;
    int freq;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(Character ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

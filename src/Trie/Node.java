package Trie;

public class Node {
    public static final int ALPHABET_SIZE = 26;
    public Node[] children;
    public boolean isEndOfWord;
    public int numOfChildren;

    public Node() {
        children = new Node[ALPHABET_SIZE];
        isEndOfWord = false;
        numOfChildren = 0;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            children[i] = null;
        }
    }

}

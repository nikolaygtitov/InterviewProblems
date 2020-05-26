package Trie;

public class Trie {
    static Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String name) {
        int index;
        Node node = root;

        for (int level = 0; level < name.length(); level++) {
            index = name.charAt(level) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
            node.numOfChildren++;
        }
        node.isEndOfWord = true;
    }

    public boolean searchWord(String key) {
        Node node = getLastNode(key);
        return (node != null && node.isEndOfWord);
    }

    public Node getLastNode(String key) {
        int index;
        Node node = root;

        for (int level = 0; level < key.length(); level++) {
            index = key.charAt(level) - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

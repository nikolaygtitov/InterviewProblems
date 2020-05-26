package Trie;

public class TrieTest {
    public static void main (String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        String output[] = {"Not present in trie", "Present in trie"};

        // Construct trie
        Trie trie = new Trie();
        for (int i = 0; i < keys.length ; i++) {
            trie.insert(keys[i]);
        }

        // Search for different words
        System.out.println("the --- " + (trie.searchWord("the") ? output[1] : output[0]));
        System.out.println("these --- " + (trie.searchWord("these") ? output[1] : output[0]));
        System.out.println("their --- " + (trie.searchWord("their") ? output[1] : output[0]));
        System.out.println("thaw --- " + (trie.searchWord("thaw") ? output[1] : output[0]));
    }
}

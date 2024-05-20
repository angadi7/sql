package prefix;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

 
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

  
    public boolean isPrefix(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        
       
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("bat");
        trie.insert("batch");
        trie.insert("bath");
        
      
        System.out.println(trie.isPrefix("app")); // Output: true
        System.out.println(trie.isPrefix("bat")); // Output: true
        System.out.println(trie.isPrefix("cat")); // Output: false
        System.out.println(trie.isPrefix("b"));   // Output: true
        System.out.println(trie.isPrefix("appl")); // Output: true
        System.out.println(trie.isPrefix("bathroom")); // Output: false
    }
}

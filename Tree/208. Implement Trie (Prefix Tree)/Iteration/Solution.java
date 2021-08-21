/**
 * Iteration version
 * 
 * Time complexity: insert(), search(), startsWith() O(M) (M is word.length())
 * Space complexity: insert() in O(M) (M is word.length()), search(), startsWith() in O(1)
 *
 */
class Trie {

    private static final int R = 26;
    
    private static class Node {
        boolean val;
        Node[] next;
        
        private Node () {
            this.val = false;
            next = new Node[R];
        }
        
        private Node (boolean val) {
            this.val = val;
            next = new Node[R];
        }
    }
    
    private Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node ();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.length() == 0) 
            return;
        Node x = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (x.next[c] == null) 
                x.next[c] = new Node();
            x = x.next[c];
        }
        x.val = true;
    }
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.length() == 0)
            return false;
        Node x = search(root, word);
        return x != null && x.val;
    }
    
    private Node search(Node x, String word) {
        for (int i = 0; i < word.length() && x != null; i++) {
            int c = word.charAt(i) - 'a';
            x = x.next[c];
        }
        return x;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0)
            return false;
        Node x = search(root, prefix);
        return x != null;
    }
}
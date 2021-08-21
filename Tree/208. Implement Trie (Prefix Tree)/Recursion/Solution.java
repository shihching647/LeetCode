/**
 * Resursion version
 * 
 * Time complexity: insert(), search(), startsWith() O(M) (M is word.length())
 * Space complexity: insert(), search(), startsWith() in O(M) (M is word.length())
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
        root = insert(root, word, 0);
    }
    
    private Node insert(Node x, String word, int d) {
        if (x == null) {
            x = new Node();
        }
        if (word.length() == d) {
            x.val = true;
            return x;
        }
        int c = word.charAt(d) - 'a';
        x.next[c] = insert(x.next[c], word, d + 1);
        return x;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.length() == 0)
            return false;
        Node x = search(root, word, 0);
        return x != null && x.val;
    }
    
    private Node search(Node x, String word, int d) {
        if (x == null)
            return null;
        if (d == word.length())
            return x;
        int c = word.charAt(d) - 'a';
        return search(x.next[c], word, d + 1);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0)
            return false;
        Node x = search(root, prefix, 0);
        return x != null;
    }
}
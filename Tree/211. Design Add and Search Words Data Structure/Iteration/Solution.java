/**
 * Iteration version
 * 
 * Time complexity: addWord() in O(N) (N is word.length()),  search() in O(M) M = the total number of characters in the Trie
 * Space complexity: addWord() O(1), search() O(N) (N is word.length())
 *
 */
class WordDictionary {
    
    private static final int R = 26;
    
    private static class Node {
        private boolean val;
        private Node[] next;
        
        private Node () {
            this.val = false;
            next = new Node[R];
        }
    }
    
    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
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
    
    public boolean search(String word) {
        if (word.length() == 0)
            return false;
        return search(root, word, 0);
    }
    
    private boolean search(Node x, String word, int d) {
        if (x == null) 
            return false;
        if (d == word.length())
            return x.val;
        char c = word.charAt(d);
        if (c != '.') {
            return search(x.next[c - 'a'], word, d + 1);
        }
        boolean result = false;
        for (int i = 0; i < R && !result; i++) {
            result = result | search(x.next[i], word, d + 1);
        }
        return result;
    }
    
}
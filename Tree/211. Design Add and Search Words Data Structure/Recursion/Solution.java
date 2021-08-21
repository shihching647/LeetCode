/**
 * Resursion version
 * 
 * Time complexity: addWord() in O(N) (N is word.length()),  search() in O(M) M = the total number of characters in the Trie
 * Space complexity: addWord() O(N), search() O(N) (N is word.length())
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
        root = addWord(root, word, 0);
    }
    
    private Node addWord(Node x, String word, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == word.length()) {
            x.val = true;
            return x;
        }
        int c = word.charAt(d) - 'a';
        x.next[c] = addWord(x.next[c], word, d + 1);
        return x;
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
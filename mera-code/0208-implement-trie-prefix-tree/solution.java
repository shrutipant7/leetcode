class Trie {
    class Node {
        Node[] child;
        boolean isEnd;

        public Node() {
            child = new Node[26];
        }
    }
    
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        for(Character ch : word.toCharArray()) {
            if(cur.child[ch - 'a'] == null) cur.child[ch - 'a'] = new Node();
            cur = cur.child[ch - 'a'];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        for(Character ch : word.toCharArray()) {
            if(cur.child[ch - 'a'] == null) return false;
            cur = cur.child[ch - 'a'];
        }
        return cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(Character ch : prefix.toCharArray()) {
            if(cur.child[ch - 'a'] == null) return false;
            cur = cur.child[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

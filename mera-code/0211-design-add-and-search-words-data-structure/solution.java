class WordDictionary {
    class TrieNode{
        Map<Character, TrieNode> map;
        boolean isEnd;
        public TrieNode(){
           map = new HashMap<Character, TrieNode>();
        }
    }
    
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for(Character ch : word.toCharArray()) {
            if(!cur.map.containsKey(ch)) {
                cur.map.put(ch, new TrieNode());
            }
            cur = cur.map.get(ch);
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }
    
    private boolean searchHelper(TrieNode cur, String word, int i) { //cur = c, word = car
            if(word.length() == i) return cur.isEnd;
            if(word.charAt(i) == '.') {
                for (Character c : cur.map.keySet()) {
                if (searchHelper(cur.map.get(c), word, i+1)) return true;
                }
            }
            if(!cur.map.containsKey(word.charAt(i))) return false;
            return searchHelper(cur.map.get(word.charAt(i)), word, i+1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

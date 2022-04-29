class LRUCache {
    class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode prev;
        
        ListNode(int key, int val, ListNode next, ListNode prev) {
            this.val = val;
            this.key = key;
            this.next = next;
            this.prev = prev;
        }
    }
    
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> map;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, ListNode>(capacity);
        head = new ListNode(-1, -1, null, null);
        tail = new ListNode(-1, -1, null, null);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            ListNode keyNode = map.get(key);
            if(map.size() > 1) {
                removeNode(keyNode);
                addNode(keyNode);
            }
            return keyNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode keyNode = map.get(key);
            removeNode(keyNode);
            
            addNode(new ListNode(key, value, null, null));
        } 
        else {
            if(map.size() < capacity) {
                addNode(new ListNode(key, value, null, null));
            }
            else {
                // Evict LRU
                removeNode(tail.prev);
                addNode(new ListNode(key, value, null, null));               
            }
        }
    }
    
    private void addNode(ListNode keyNode) {
        keyNode.next = head.next;
        keyNode.prev = head;
        keyNode.next.prev = keyNode;
        head.next = keyNode;
        map.put(keyNode.key, keyNode);
    }
    
    private void removeNode(ListNode keyNode) {
        keyNode.prev.next = keyNode.next;
        keyNode.next.prev = keyNode.prev;
        map.remove(keyNode.key);
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

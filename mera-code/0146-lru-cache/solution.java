class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        ListNode remNode = removeNode(key);
        addNodeToHead(remNode);
        return remNode.val;
    }

    public void addNodeToHead(ListNode newNode) {
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        map.put(newNode.key, newNode);
    }

    public ListNode removeNode(int key) {
        ListNode node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        return node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode remNode = removeNode(key);
            remNode.val = value;
            addNodeToHead(remNode);
            return;
        }
        addNodeToHead(new ListNode(key, value));
        if (map.size() > capacity) {
            int remKey = tail.prev.key;
            removeNode(remKey);
            map.remove(remKey);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

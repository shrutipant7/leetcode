/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node originalHead = head;
        if(head == null) return null;
        // if(head.next == null) return new Node(head.val);
        while(originalHead != null) {
            Node temp = originalHead.next;
            originalHead.next = new Node(originalHead.val);
            originalHead.next.next=temp;
            originalHead=temp;
        }
        originalHead = head;
        while(originalHead != null) {
            if(originalHead.next != null) {
                originalHead.next.random=originalHead.random != null ? originalHead.random.next : null;
            }
                originalHead=originalHead.next.next;
        }
        originalHead = head;
        Node copyHead = head.next;
        Node temp = copyHead;
        while(originalHead != null) {
            originalHead.next= originalHead.next.next;
            copyHead.next= copyHead.next != null ? copyHead.next.next : null;
            copyHead=copyHead.next;
            originalHead=originalHead.next;
        }
        return temp;
    }
}

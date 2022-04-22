/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode ptr = head;
        ListNode tail = null;
        int len = 0;
        if(k ==0 || head == null || head.next == null) return head;
        while(ptr != null) {
            len++;
            tail = ptr;
            ptr = ptr.next;
        }
        if(k%len == 0) return head;
        
        int newTail = len-(k%len)-1;
        ListNode tailPtr = head;
        while(tailPtr != null && newTail > 0) {
            tailPtr = tailPtr.next;
            newTail--;
        }
        ListNode newHead = tailPtr.next;
        tailPtr.next = null;
        tail.next = head;
        return newHead;
    }
}

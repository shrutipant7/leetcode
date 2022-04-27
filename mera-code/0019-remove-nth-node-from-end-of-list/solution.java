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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode slow = new ListNode(-1, head);
        ListNode fast = head;
        while(fast.next != null) {
            fast = fast.next;
            if(n <= 1) slow = slow.next;
            n--;
        }
        if(slow.next != null) {
            if(slow.next == head) return head.next;
            slow.next = slow.next.next;
        }
        return head;
    }
}

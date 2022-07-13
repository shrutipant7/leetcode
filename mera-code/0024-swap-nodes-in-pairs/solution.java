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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;
        ListNode groupNext = head;
        while(true) {
            ListNode end = dummy.next;
            if(groupPrev.next != null && groupPrev.next.next != null)
                end = groupPrev.next.next;
            else break;
            ListNode current = groupPrev.next;
            ListNode prev = end.next;
            groupNext = end.next;
            while(current != groupNext) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = end;
            groupPrev = temp;
        }
        return dummy.next;
    }
}

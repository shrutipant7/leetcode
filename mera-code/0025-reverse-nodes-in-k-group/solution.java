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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;
        ListNode groupNext = head;
        while(true) {
            ListNode current = groupPrev.next;
            ListNode end = findEnd(groupPrev, k);
            if(end == null) break;
            ListNode prev = end.next;
            groupNext = end.next;
            
            //Logic for reverse            
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
    
    public ListNode findEnd(ListNode start, int k) {
        ListNode end = start;
        while(end != null && k > 0) {
            end = end.next;
            k--;
        }
        return end;
    }
}

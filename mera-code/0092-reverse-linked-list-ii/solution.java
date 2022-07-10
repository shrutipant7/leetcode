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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode prev = null;
        ListNode current = head;
        for(int i=0; i < left-1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode subListTail = current;
        ListNode subListPrev = prev;
        prev = null;
        ListNode temp = null;
        for(int i=0; i <= right-left; i++) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        subListTail.next = current;
        if(subListPrev != null) {
            subListPrev.next = prev;
        } 
        else head = prev;
        return head;
    }
}

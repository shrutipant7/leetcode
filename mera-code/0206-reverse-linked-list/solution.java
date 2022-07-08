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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        // ------- Iterative -----------
        // ListNode prev = null;
        // ListNode temp = null;
        // while(head != null) {
        //     temp = head.next;
        //     head.next = prev;
        //     prev = head;
        //     head = temp;
        // }
        // return prev;
        
        // ----------- Recursive ---------
        return recursiveFunction(head, null);        
    }
    
    public ListNode recursiveFunction(ListNode head, ListNode prev) {
        if(head == null) return prev;
        ListNode temp = head.next;
        head.next = prev;
        return recursiveFunction(temp, head);
    }
}

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
    // static ListNode findHead(ListNode head) {
    //     if(head == null){
    //         return null;
    //     }
    //     findHead(head.next);
    // }
    public ListNode removeElements(ListNode head, int val) {
         if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
        
}

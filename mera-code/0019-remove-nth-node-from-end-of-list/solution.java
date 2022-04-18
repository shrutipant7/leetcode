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
        int sz = 1; //3
        ListNode tempHead = head;
        while(tempHead != null) {
            sz++;
            tempHead = tempHead.next;
        }
        tempHead = head;
        int szNew = 1;
        while(tempHead != null) {
            if(sz-n == 1) {
                return head.next;
            }
            szNew++;
            if(sz-n == szNew) { //2
                tempHead.next = tempHead.next == null ? null : tempHead.next.next;
                return head;
            }
            tempHead = tempHead.next;
        }
        return head;
    }
}

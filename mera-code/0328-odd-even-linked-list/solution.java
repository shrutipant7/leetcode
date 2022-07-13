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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        while(even != null && even.next != null) {
            ListNode tempOdd = even.next;
            odd.next = tempOdd;
            odd = tempOdd;
            ListNode tempEven = even.next.next;
            even.next = tempEven;
            even = tempEven;
        }
        odd.next = evenHead;
        return head;
    }
}

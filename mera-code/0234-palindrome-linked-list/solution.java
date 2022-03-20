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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null) {
            return head;
        }
        while(fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
        ListNode temp = cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode revHead = reverse(middleNode(head).next);
        while(revHead != null && head != null) {
            if(head.val != revHead.val) {
                return false;
            }
            revHead=revHead.next;
            head=head.next;
        }
        return true;
    }
}

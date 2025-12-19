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
    public int pairSum(ListNode head) {
        int maxSum = 0;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null)
                slow = slow.next;
        }
        slow.next = revLL(slow.next);

        ListNode first = head, second = slow.next;
        while (second != null) {
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return maxSum;
    }

    public ListNode revLL(ListNode head) {
        ListNode tail = head;
        ListNode l = head, r = head.next;
        while (r != null) {
            ListNode temp = r.next;
            r.next = l;
            l = r;
            r = temp;
        }
        tail.next = null;
        return l;
    }
}

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
    public void reorderList(ListNode head) {
        ListNode ptr = head;
        Stack<ListNode> stack = new Stack<>();
        while (ptr != null) {
            stack.push(ptr);
            ptr = ptr.next;
        }
        ptr = head;
        while(ptr != null && ptr.next != null) {
            ListNode top = stack.pop();
            stack.peek().next = null;
            top.next = ptr.next;
            ptr.next = top;
            ptr = ptr.next.next;
        }
    }
}

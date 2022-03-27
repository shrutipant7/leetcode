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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while(l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val;
            ListNode newNode = new ListNode();
            if(head == null) {
                carry = updateNewNode(sum, newNode, carry);
                head = newNode; 
                tail = newNode;
            }
            else {
                carry = updateNewNode(sum, newNode, carry);         
                // System.out.println(top + ":" + newNode.val + ":" + carry);      
                tail.next = newNode;
                tail = tail.next;
            }
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        if(carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
    static int updateNewNode(int sum, ListNode newNode, int carry) {
        if(sum/10 >= 1) { //Check if number has more than 1 digit
            newNode.val = sum%10 + carry;
            return 1;
        } else {
            int carriedSum = sum + carry;
            newNode.val = carriedSum%10;
            return carriedSum/10>=1 ? 1 : 0;
        }
    }
}

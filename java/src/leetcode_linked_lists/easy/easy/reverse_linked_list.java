/**
 * 
 * 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.

 
 */

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
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
    private ListNode recursiveReverse(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode p = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
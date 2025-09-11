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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        // find length & connect tail to head
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) { tail = tail.next; len++; }
        tail.next = head;
        
        // move to new tail
        k %= len;
        int steps = len - k;
        ListNode newTail = head;
        for (int i = 1; i < steps; i++) newTail = newTail.next;
        
        // break circle
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}

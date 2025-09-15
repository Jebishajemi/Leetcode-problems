class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // split list
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // cut list

        // sort halves
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // merge halves
        return merge(l1, l2);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) { tail.next = a; a = a.next; }
            else { tail.next = b; b = b.next; }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }
}

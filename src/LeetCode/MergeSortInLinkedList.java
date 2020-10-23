package LeetCode;

public class MergeSortInLinkedList {
    public ListNode sortList(ListNode head) {
        ListNode end = head;
        while (end.next != null) end = end.next;

        return mergesort(head);
    }

    private ListNode mergesort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = findMid(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;
        ListNode left = mergesort(head);
        ListNode right = mergesort(nextOfMiddle);
        ListNode merge = merge(left, right);
        return merge;
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null || right == null) return (left == null ? right : left);

        ListNode localHead = null;
        if (left.val <= right.val) {
            localHead = left;
            left.next = merge(left.next, right);
        } else {
            localHead = right;
            right.next = merge(left, right.next);
        }
        return localHead;
    }

    private ListNode findMid(ListNode head) {
        if (head == null) return head;

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

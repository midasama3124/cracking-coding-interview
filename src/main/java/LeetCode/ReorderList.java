package LeetCode;

import java.util.List;

public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Head of first half
        ListNode h1 = head;
        // Tail of first half
        ListNode prev = null;
        // Head of second half
        ListNode slow = head;
        // Tail of second half
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode h2 = reverse(slow);

        merge(h1, h2);

        printList(head);
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }

    private static void merge(ListNode h1, ListNode h2) {
        while (h1 != null) {
            ListNode tmp1 = h1.next;
            ListNode tmp2 = h2.next;

            h1.next = h2;

            if (tmp1 == null) break;

            h2.next = tmp1;
            h1 = tmp1;
            h2 = tmp2;
        }
    }

    private static void printList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(head);
    }
}

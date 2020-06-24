package LeetCode;

public class OddEvenLinkedList {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static ListNode oddEvenList(ListNode head) {
    if (head == null) return null;

    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;

    // Connecting odd/even nodes to their following odd/even node
    // so that we turn out with two separates LinkedLists
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    // Tie up the separate LinkedLists
    odd.next = evenHead;
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode node = head;
    for (int i=2; i <= 5; i++) {
      node.next = new ListNode(i);
      node = node.next;
    }
    node.next = null;
    head = oddEvenList(head);
    node = head;
    while (node.next != null) {
      System.out.println(node.val);
      node = node.next;
    }
    System.out.println(node.val);
  }
}

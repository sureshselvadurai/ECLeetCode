package helper;

  public class ListNode {
      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      public static void printList(ListNode listNode) {
          ListNode current = listNode;
          while (current != null) {
              System.out.print(current.val + "->");
              current = current.next;
          }
      }
  }
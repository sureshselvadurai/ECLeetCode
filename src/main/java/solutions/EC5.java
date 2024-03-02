package solutions;
import helper.ListNode;

//Problem 1 :328. Odd Even Linked List (Medium)
//  Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
//  The first node is considered odd, and the second node is even, and so on.
//  Note that the relative order inside both the even and odd groups should remain as it was in the input.
//  You must solve the problem in O(1) extra space complexity and O(n) time complexity.
//  Reference : https://leetcode.com/problems/odd-even-linked-list/description/


//Problem 1 :1721. Swapping Nodes in a Linked List (Medium)
//        You are given the head of a linked list, and an integer k.
//        Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
//Reference : https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/
public class EC5 {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;

        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }

    public static ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        ListNode kthFromBegin = null;
        ListNode kthFromEnd = null;
        current = head;
        for (int i = 1; i <= length; i++) {
            if (i == k) {
                kthFromBegin = current;
            }
            if (i == length - k + 1) {
                kthFromEnd = current;
            }
            current = current.next;
        }

        int temp = kthFromBegin.val;
        kthFromBegin.val = kthFromEnd.val;
        kthFromEnd.val = temp;

        return head;
    }

    public static void main(String[] args) {

//        Solution 1 Test
        ListNode listNode1 = new ListNode(3,new ListNode(4,new ListNode(5)));
        ListNode listNode2 = new ListNode(1,new ListNode(2,listNode1));
        ListNode.printList(oddEvenList(listNode1));
        ListNode.printList(swapNodes(listNode2,1));
    }
}

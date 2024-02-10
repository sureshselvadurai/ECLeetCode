package solutions;
import helper.ListNode;

//Problem 1 : 203. Remove Linked List Elements
//        Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
//Reference : https://leetcode.com/problems/remove-linked-list-elements/description/

//Problem 2 :326. Power of Three
//        Given an integer n, return true if it is a power of three. Otherwise, return false.
//        An integer n is a power of three, if there exists an integer x such that n == 3x.
//Reference : https://leetcode.com/problems/power-of-three/description/

//Problem 3 :509. Fibonacci Number
//        The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
//
//        F(0) = 0, F(1) = 1
//        F(n) = F(n - 1) + F(n - 2), for n > 1.
//        Given n, calculate F(n).
//Ref : https://leetcode.com/problems/fibonacci-number/description/

public class EC2 {

//    Problem 1 Solution
    public static ListNode removeElements(ListNode head, int val) {
        if (head==null)
            return null;
        if(head.val == val){
            return removeElements(head.next,val);
        }else
            head.next = removeElements(head.next,val);
            return head ;
    }

//    Problem 2 Solution
    public static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }else if (n % 3 == 0) {
            return isPowerOfThree(n / 3);
        } else return n == 1;
    }

//    Problem 3 Solution
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {

//        Solution Test
        ListNode listNode1 = new ListNode(1,new ListNode(3,new ListNode(1)));
        ListNode listNode2 = new ListNode(2,new ListNode(4,new ListNode(6)));
        ListNode.printList(removeElements(listNode1,1));
        System.out.println(isPowerOfThree(0));
        System.out.println(fib(2));

    }


}
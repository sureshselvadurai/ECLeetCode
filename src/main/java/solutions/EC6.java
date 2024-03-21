package solutions;
import helper.ListNode;
import helper.TreeNode;

//Problem 1 : 98. Validate Binary Search Tree (Medium)
//Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//        A valid BST is defined as follows:
//        The left
//        subtree
//        of a node contains only nodes with keys less than the node's key.
//        The right subtree of a node contains only nodes with keys greater than the node's key.
//        Both the left and right subtrees must also be binary search trees.
//    Reference :https://leetcode.com/problems/validate-binary-search-tree/description/


//Problem 2 : 109. Convert Sorted List to Binary Search Tree (Medium)
//        Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
//        height-balanced
//        binary search tree.
//        Reference :https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/


public class EC6 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;

        if (head == tail) return null;

        // Find the middle node using slow and fast pointers
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = toBST(head, slow);
        node.right = toBST(slow.next, tail);

        return node;
    }
    public static void main(String[] args) {

        EC6 solution = new EC6();

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Is BST 1 valid? " + solution.isValidBST(root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Is BST 2 valid? " + solution.isValidBST(root2));

        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode bstRoot = solution.sortedListToBST(head);
    }
}

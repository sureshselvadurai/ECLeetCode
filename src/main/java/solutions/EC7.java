package solutions;

//Problem 1 : 129. Sum Root to Leaf Numbers (Medium)
//You are given the root of a binary tree containing digits from 0 to 9 only.
//Each root-to-leaf path in the tree represents a number.
//For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
//A leaf node is a node with no children.
//    Reference :https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

//Problem 2 : 337. House Robber III (Medium)
//The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
//        Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
//        Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
//    Reference :https://leetcode.com/problems/house-robber-iii/description/

import helper.TreeNode;

public class EC7 {

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;
        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);
        return leftSum + rightSum;
    }

    public static int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    private static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int notRobbed = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int robbed = node.val + left[0] + right[0];

        return new int[]{notRobbed, robbed};
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        int result1 = sumNumbers(root1);
        System.out.println("Example 1 Result: " + result1);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);
        int result2 = rob(root2);
        System.out.println("Example 2 Result: " + result2);

    }
}

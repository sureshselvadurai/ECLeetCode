package solutions;

import helper.MinHeap;
import helper.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Problem 1 : 1315. Sum of Nodes with Even-Valued Grandparent (Medium)
//Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.
//A grandparent of a node is the parent of its parent if it exists.
//    Reference : https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/

//Problem 2 :654. Maximum Binary Tree (Medium)
//You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
//Create a root node whose value is the maximum value in nums.
//Recursively build the left subtree on the subarray prefix to the left of the maximum value.
//Recursively build the right subtree on the subarray suffix to the right of the maximum value.
//Return the maximum binary tree built from nums.
//    Reference : https://leetcode.com/problems/maximum-binary-tree/description/

public class EC9 {

//    Problem 1:
    public static int sumEvenGrandparent(TreeNode root) {
        return dfs(root, null, null);
    }

    private static int dfs(TreeNode node, TreeNode parent, TreeNode grandparent) {
        if (node == null) {
            return 0;
        }

        int sum = 0;
        if (grandparent != null && grandparent.val % 2 == 0) {
            sum += node.val;
        }

        sum += dfs(node.left, node, parent);
        sum += dfs(node.right, node, parent);

        return sum;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length-1);

    }

    public static TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if(start>end){
            return null;
        }
        int highIndex = start;
        int maxVal = nums[start];
        for(int i = start+1;i<=end;i++){
            if(nums[i]>maxVal){
                maxVal = nums[i];
                highIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[highIndex]);
        node.left = constructMaximumBinaryTree(nums,start,highIndex-1);
        node.right = constructMaximumBinaryTree(nums,highIndex+1,end);

        return node;

    }
    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(1);
        root1.right.right = new TreeNode(6);

        System.out.println("Example 1: " + sumEvenGrandparent(root1));

        int[] arr = {3,2,1,6,0,5};
        TreeNode maxTree = constructMaximumBinaryTree(arr);
        maxTree.printTree();

    }
}

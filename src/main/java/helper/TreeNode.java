package helper;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void printTree() {
        printTree(this, 0);
    }

    private void printTree(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        // Print the current node
        for (int i = 0; i < depth; i++) {
            System.out.print("  "); // Indent based on the depth
        }
        System.out.println(node.val);

        // Recursively print left and right subtrees
        printTree(node.left, depth + 1);
        printTree(node.right, depth + 1);
    }
}


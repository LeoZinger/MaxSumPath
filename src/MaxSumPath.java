public class MaxSumPath {
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode (5);
        root.left = new TreeNode (2);
        root.right = new TreeNode (7);

        root.left.left = new TreeNode (1);
        root.left.right = new TreeNode (3);

        root.right.left = new TreeNode (6);
        root.right.right = new TreeNode (8);

        MaxSumPath maxSumPath = new MaxSumPath();
        int maxSum = maxSumPath.maxPathSum(root);
        System.out.println("Max Sum Path = " + maxSum);
    }
}
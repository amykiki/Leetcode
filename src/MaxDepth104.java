/**
 * Created by Amysue on 2016/7/16.
 */
public class MaxDepth104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = getDepth(root);
        return maxDepth;
    }

    private int getDepth(TreeNode node) {
        int leftDep = 0;
        int rightDep = 0;
        if (node.left != null) {
            leftDep = getDepth(node.left);
        }
        if (node.right != null) {
            rightDep = getDepth(node.right);
        }
        return 1 + (leftDep > rightDep ? leftDep : rightDep);
    }

    public static void main(String[] args) {
        MaxDepth104 mp = new MaxDepth104();
        TreeNode root = new TreeNode(0);
        int depth = mp.maxDepth(root);
        System.out.println("depth = " + depth);
    }
}

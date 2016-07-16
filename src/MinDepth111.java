/**
 * Created by Amysue on 2016/7/16.
 */
public class MinDepth111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = getMinDepth(root);
        return minDepth;
    }

    private int getMinDepth(TreeNode node) {
        int leftDep  = 0;
        int rightDep = 0;
        if (node.left != null) {
            leftDep = getMinDepth(node.left);
        }
        if (node.right != null) {
            rightDep = getMinDepth(node.right);
        }
        if (leftDep == 0) {
            return 1 + rightDep;
        }
        if (rightDep == 0) {
            return 1 + leftDep;
        }
        return 1 + (leftDep > rightDep ? rightDep : leftDep);
    }
}

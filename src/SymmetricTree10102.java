import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amysue on 2016/7/21.
 */
public class SymmetricTree10102 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            TreeNode[] nodes = {root.left, root.right};
            return levelSymmetric(nodes);
        } else if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    private boolean levelSymmetric(TreeNode[] nodes) {
        if (nodes.length == 1 || nodes.length % 2 == 1) {
            return false;
        }
        int        nextCount = nodes.length * 2;
        TreeNode[] nextNodes = new TreeNode[nextCount];
        boolean    notNull   = false;
        for (int i = 0; i < nodes.length / 2; i++) {
            TreeNode leftNode  = nodes[i];
            TreeNode rightNode = nodes[nodes.length - 1 - i];
            if (leftNode == null) {
                continue;
            }
            if (leftNode.val != rightNode.val) {
                return false;
            }
            int nextIndex = i*2;
            if (leftNode.left != null && rightNode.right != null) {
                nextNodes[nextIndex] = leftNode.left;
                nextNodes[nextCount - 1 - nextIndex] = rightNode.right;
                notNull = true;
            } else if (leftNode.left == null && rightNode.right == null) {

            } else {
                return false;
            }
            if (leftNode.right != null && rightNode.left != null) {
                nextNodes[nextIndex + 1] = leftNode.right;
                nextNodes[nextCount - 2 - nextIndex] = rightNode.left;
                notNull = true;
            } else if (leftNode.right == null && rightNode.left == null) {

            } else {
                return false;
            }
        }
        if (!notNull) {
            return true;
        } else {
            return levelSymmetric(nextNodes);
        }
    }

    public static void main(String[] args) {
        SymmetricTree10102 sy = new SymmetricTree10102();
//        Integer[]        nodes = {1,  2, 2, null, 3, null, 3};
//        Integer[]        nodes = {1,2,2,3,4,4,3};
//        Integer[]        nodes = {1,2,2,3,4,4,3,null,null,5,null,5,null,null,null};
//        Integer[] nodes = {1,2,null,null,3,null,null,null,null,4,null,null,null,null,null};
//        Integer[]  nodes = {2, 3, 3, 4, 5, null, 4};
//        Integer[]  nodes = {2,3,null};
        Integer[] nodes = {2,-75,-75,95,-61,-61,95,75,9,-73,-11,-11,-73,8,75};
        BinaryTree tr    = new BinaryTree(nodes);
        TreeNode   root  = tr.getRoot();
        System.out.println(sy.isSymmetric(root));

    }
}

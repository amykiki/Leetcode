import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Amysue on 2016/7/21.
 */
public class SymmetricTree101 {
    /*
    * 采用数组，效率严重降低，这不是一个好的算法
    * 因为这种方法造成大量空间的浪费，而且对于每行，要一个一个查询，很慢*/
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> nodes = new ArrayList<>();
        if (root.left != null && root.right != null) {
            nodes.add(root.left);
            nodes.add(root.right);
            return levelSymmetric(nodes);
        } else if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    private boolean levelSymmetric(List<TreeNode> nodes) {
        if (nodes.size() == 1 || nodes.size() % 2 == 1) {
            return false;
        }
        List<TreeNode> nextNodes = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i += 2) {
            TreeNode leftNode  = nodes.get(i);
            TreeNode rightNode = nodes.get(i + 1);
            if (leftNode.val != rightNode.val) {
                return false;
            }
            if (leftNode.left != null && rightNode.right != null) {
                nextNodes.add(leftNode.left);
                nextNodes.add(rightNode.right);
            } else if (leftNode.left == null && rightNode.right == null) {

            } else {
                return false;
            }
            if (leftNode.right != null && rightNode.left != null) {
                nextNodes.add(leftNode.right);
                nextNodes.add(rightNode.left);
            } else if (leftNode.right == null && rightNode.left == null) {

            } else {
                return false;
            }
        }
        if (nextNodes.isEmpty()) {
            return true;
        } else {
            return levelSymmetric(nextNodes);
        }
    }

    public static void main(String[] args) {
        SymmetricTree101 sy    = new SymmetricTree101();
//        Integer[]        nodes = {1,  2, 2, null, 3, null, 3};
//        Integer[]        nodes = {1,2,2,3,4,4,3};
//        Integer[]        nodes = {1,2,2,3,4,4,3,null,null,5,null,5,null,null,null};
//        Integer[] nodes = {1,2,null,null,3,null,null,null,null,4,null,null,null,null,null};
        Integer[] nodes = {2,3,3,4,5,null,4};
        BinaryTree tr   = new BinaryTree(nodes);
        TreeNode   root = tr.getRoot();
        System.out.println(sy.isSymmetric(root));

    }
}

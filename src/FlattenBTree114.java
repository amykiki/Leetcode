import java.util.LinkedList;

/**
 * Created by Amysue on 2016/7/26.
 */
public class FlattenBTree114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.push(root);
        TreeNode n = null;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            if (node.right != null) {
                nodes.push(node.right);
                node.right = null;
            }
            if (node.left != null) {
                nodes.push(node.left);
                node.left = null;
            }
            if (n == null) {
                n = node;
            } else {
                n.right = node;
                n = node;
            }
        }
    }

    public static void main(String[] args) {
        FlattenBTree114 fb = new FlattenBTree114();
        Integer[] nodes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        BinaryTree bt = new BinaryTree(nodes);
        TreeNode root = bt.getRoot();
        fb.flatten(root);
    }
}

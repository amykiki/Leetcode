import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amysue on 2016/7/18.
 */
public class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public List<Integer> inorder() {
        List<Integer> list = new ArrayList<>();
        inorderTree(root, list);
        return list;
    }

    private void inorderTree(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inorderTree(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            inorderTree(node.right, list);
        }
    }
}

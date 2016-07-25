import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Amysue on 2016/7/25.
 */
public class BTreePreorder144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        if (root == null) {
            return vals;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.push(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            if (node.right != null) {
                nodes.push(node.right);
            }
            if (node.left != null) {
                nodes.push(node.left);
            }
            vals.add(node.val);
        }
        return vals;
    }

    public static void main(String[] args) {
        BTreePreorder144 btpre = new BTreePreorder144();
//        Integer[] nodes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Integer[] nodes = {1, 2, null, 4, 5, null, null, 8, 9, 10, 11, null, null, null, null};
        BinaryTree bt = new BinaryTree(nodes);
        TreeNode root = bt.getRoot();
        List<Integer> preorder = btpre.preorderTraversal(root);
        System.out.println(preorder);
    }
}

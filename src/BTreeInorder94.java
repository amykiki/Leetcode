import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Amysue on 2016/7/25.
 */
public class BTreeInorder94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        if (root == null) {
            return vals;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.push(root);
        LinkedList<TreeNode> leftNodes = new LinkedList<>();
        while (!nodes.isEmpty()) {

            if (nodes.peek().left != null) {
                if (nodes.peek().left == leftNodes.peek()) {
                    leftNodes.pop();
                } else {
                    TreeNode leftNode = nodes.peek().left;
                    nodes.push(leftNode);
                    leftNodes.push(leftNode);
                    continue;
                }
            }
            TreeNode node = nodes.pop();
            vals.add(node.val);
            if (node.right != null) {
                nodes.push(node.right);
            }
        }

        return vals;
    }

    public static void main(String[] args) {
        BTreeInorder94 bTreeInorder94 = new BTreeInorder94();
//        Integer[] nodes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Integer[] nodes = {1, 2, null, null, 5, null, null, null, null, 10, 11, null, null, null, null};
//        Integer[]    nodes        = {1, 2, null, 4, 5, null, null, 8, 9, 10, 11, null, null, null, null};
        BinaryTree   bt           = new BinaryTree(nodes);
        TreeNode     root         = bt.getRoot();
        BuildTree105 buildTree105 = new BuildTree105();
        int[]        inorder3     = {2, 4, 6, 5, 3, 1};
        int[]        preorder3    = {1, 2, 3, 4, 5, 6};
//        TreeNode root = buildTree105.buildTree(preorder3, inorder3);
        List<Integer> vals = bTreeInorder94.inorderTraversal(root);
        System.out.println(vals);
    }
}

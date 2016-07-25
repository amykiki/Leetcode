import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Amysue on 2016/7/25.
 */
public class BTreePostorder145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        if (root == null) {
            return vals;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.push(root);
        TreeNode lastPop = null;
        while (!nodes.isEmpty()) {
            if (nodes.peek() == null) {
                nodes.pop();
            } else {
                if (nodes.peek().left != null && nodes.peek().left != lastPop) {
                    nodes.push(nodes.peek().left);
                    continue;
                }
                if (nodes.peek().right != null) {
                    TreeNode rightNode = nodes.peek().right;
                    nodes.push(null);
                    nodes.push(rightNode);
                    continue;
                }
            }
            TreeNode node = nodes.pop();
            vals.add(node.val);
            lastPop = node;
        }
        return vals;
    }

    public static void main(String[] args) {
        BTreePostorder145 btpost = new BTreePostorder145();
        Integer[] nodes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//        Integer[] nodes = {1, 2, null, 4, 5, null, null, 8, 9, 10, 11, null, null, null, null};
        BinaryTree bt = new BinaryTree(nodes);
//        TreeNode root = bt.getRoot();
        BuildTree105  buildTree105 = new BuildTree105();
        int[]         inorder3     = {2,4,6,5,3,1};
        int[]         preorder3    = {1,2,3,4,5,6};
        TreeNode root = buildTree105.buildTree(preorder3, inorder3);
        List<Integer> postorder = btpost.postorderTraversal(root);
        System.out.println(postorder);
    }
}

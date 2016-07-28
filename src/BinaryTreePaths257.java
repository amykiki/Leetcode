import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amysue on 2016/7/28.
 */
public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        goPath(root, new StringBuilder(), results);
        return results;
    }

    private void goPath(TreeNode node, StringBuilder sb, List<String> results) {
        if (sb.length() != 0) {
            sb.append("->");
        }
        sb.append(node.val);
        int start = sb.length();
        if (node.left != null) {
            goPath(node.left, sb, results);
        }
        sb.delete(start, sb.length());
        if (node.right != null) {
            goPath(node.right, sb, results);
        }
        sb.delete(start, sb.length());
        if (node.left == null && node.right == null) {
            results.add(sb.toString());
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 3, 8, 2, 4, 7, 9, 1, 123, null, null, 6};
        BinaryTree bt = new BinaryTree(nums);
        BinaryTreePaths257 btp = new BinaryTreePaths257();
        List<String> paths = btp.binaryTreePaths(bt.getRoot());
        System.out.println(paths);
    }
}

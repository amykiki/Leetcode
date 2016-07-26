import java.util.LinkedList;

/**
 * Created by Amysue on 2016/7/26.
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        TreeNode p = root;
        Integer last = null;
        while (!nodes.isEmpty() || p != null) {
            while (p!= null && p.left != null) {
                nodes.push(p);
                p = p.left;
            }
            if (p == null) {
                p = nodes.pop();
            }
            if (last != null && p.val <= last) {
                return false;
            }
            last = p.val;
            if (!nodes.isEmpty() && p.val >= nodes.peek().val) {
                return false;
            }
            if (p.right != null) {
                if (p.val >= p.right.val) {
                    return false;
                }
                p = p.right;
            } else {
                p = null;
            }
        }
        return true;
    }

}

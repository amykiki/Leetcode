import java.util.LinkedList;

/**
 * Created by Amysue on 2016/7/26.
 */
public class ValidateBST98 {
    /*public boolean isValidBST(TreeNode root) {
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
    }*/
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, null, null);
    }

    private boolean isValidNode(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        boolean left = true;
        boolean right = true;
        if (node.left != null) {
            if (node.left.val >= node.val || (low != null && node.left.val <= low)) {
                return false;
            }
            left = isValidNode(node.left, low, node.val);
        }
        if (node.right != null) {
            if (node.right.val <= node.val || (high != null && node.right.val >= high)) {
                return false;
            }
            right = isValidNode(node.right, node.val, high);
        }
        return (left&&right);
    }

}

/**
 * Created by Amysue on 2016/7/26.
 */
public class RecoverTree99 {
    public void recoverTree(TreeNode root) {
        TreeNode[] results = new TreeNode[4];
        boolean result = validNode(root, null, null, results);
        if (!result && results[2] == null) {
            int tmp = results[0].val;
            results[0].val = results[1].val;
            results[1].val = tmp;
        }
    }

    private boolean validNode(TreeNode node, TreeNode low, TreeNode high, TreeNode[] results) {
        if (node == null) {
            return true;
        }
        if (low != null) {
            if (node.val < low.val) {
                results[2] = node;
                results[3] = low;

                if (results[0] != null) {
                    int tmp = results[0].val;
                    results[0].val = node.val;
                    node.val = tmp;
                }
                else {
                    TreeNode p = node.right;
                    while (p != null) {
                        if (low.val < p.val) {
                            p = p.left;
                        } else {
                            if (p.val < node.val) {
                                break;
                            } else {
                                p = p.right;
                            }
                        }
                    }
                    if (p == null) {
                        p = node;
                    }
                    int tmp = low.val;
                    low.val = p.val;
                    p.val = tmp;
                }
                return false;
            }
        }
        if (high != null) {
            if (node.val > high.val) {
                results[0] = node;
                results[1] = high;
                TreeNode p = node.left;
                while (p != null) {
                    if (high.val > p.val) {
                        p = p.right;
                    } else {
                        if (p.val > node.val) {
                            break;
                        } else {
                            p = p.left;
                        }
                    }
                }
                if (p != null) {
                    results[2] = p;
                    int tmp = p.val;
                    p.val = high.val;
                    high.val = tmp;
                }

                return false;
            }
        }
        boolean left = validNode(node.left, low, node, results);
        if (!left) {
            if (results[2] != null) {
                return false;
            }
        }
        boolean right = validNode(node.right, node, high, results);
        if (!left && !right) {
            if (results[2] == null) {
                int tmp = node.val;
                node.val = results[0].val;
                results[0].val = tmp;
                results[2] = node;
            }
        }
        return left&&right;
    }

    public static void main(String[] args) {
        RecoverTree99 rc = new RecoverTree99();
//        Integer[] nums = {5, 3, 8, 2, 4, 7, 9, 1, null, null, null, 6};
        Integer[] nums = {1, 3, 8, 2, 4, 7, 9, 5, null, null, null, 6};
//        Integer[] nums = {9, 3, 8, 2, 4, 7, 5, 1, null, null, null, 6};
//        Integer[] nums = {5, 2, 8, 3, 4, 7, 9, 1, null, null, null, 6};
//        Integer[] nums = {3, 5, 8, 2, 4, 7, 9, 1, null, null, null, 6};
//        Integer[] nums = {5, 3, 8, 2, 4, 7, 1, 9, null, null, null, 6};
//        Integer[] nums = {6, 3, 8, 2, 4, 7, 9, 1, null, null, null, 5};
//        Integer[]  nums = {5, 3, 8, 9, 4, 7, 2, 1, null, null, null, 6};
//        Integer[]  nums = {5, 3, 8, 2, 9, 7, 4, 1, null, null, null, 6};
//        Integer[] nums = {3,null,2,null,null,null,1};
        BinaryTree bt   = new BinaryTree(nums);
        TreeNode   root = bt.getRoot();
        rc.recoverTree(root);
        System.out.println(1);
    }
}

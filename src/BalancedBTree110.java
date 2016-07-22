/**
 * Created by Amysue on 2016/7/22.
 */
public class BalancedBTree110 {
    public boolean isBalanced(TreeNode root) {
        int height = getDepth(root);
        if (height == -1) {
            return false;
        }
        return true;
    }
    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) >= 2) {
            return -1;
        }
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    public static void main(String[] args) {
        BalancedBTree110 bbt = new BalancedBTree110();
//        Integer[] nodes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, 11, 12, 13, 14, 15, 16, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
//        Integer[]  nodes = {1};
//        Integer[] nodes = {1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5};
        Integer[] nodes = {1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5,5,5,5,5,5,5,5};
//        Integer[] nodes = {1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5};
        BinaryTree bt    = new BinaryTree(nodes);
        TreeNode   root  = bt.getRoot();
        System.out.println(bbt.isBalanced(root));
    }

}

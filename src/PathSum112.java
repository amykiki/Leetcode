/**
 * Created by Amysue on 2016/7/24.
 */
public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return find(root, 0, sum);
    }

    private boolean find(TreeNode node, int lastSum, int sum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            if ((node.val + lastSum) == sum) {
                return true;
            } else {
                return false;
            }
        } else {
            lastSum += node.val;
            if (find(node.left, lastSum, sum) == true) {
                return true;
            }
            return find(node.right, lastSum, sum);
        }
    }

    public static void main(String[] args) {
        PathSum112 ps112 = new PathSum112();
        Integer[] nodes = {5,4,8,11,null,13,4,7,2,null,null,null,null,null,1};
        BinaryTree bt = new BinaryTree(nodes);
        TreeNode root = bt.getRoot();
        System.out.println(ps112.hasPathSum(root, 22));

    }
}

/**
 * Created by Amysue on 2016/7/28.
 */
public class SumRootToLeaf129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] allSum = new int[1];
        sumNode(root, 0, allSum);
        return allSum[0];
    }

    private void sumNode(TreeNode node, int lastSum, int[] allSum) {
        int curSum = lastSum*10 + node.val;
        if (node.left != null) {
            sumNode(node.left, curSum, allSum);
        }
        if (node.right != null) {
            sumNode(node.right, curSum, allSum);
        }
        if (node.left == null && node.right == null) {
            allSum[0] += curSum;
        }
    }


    public static void main(String[] args) {
        Integer[] nums = {5, 3, 8, 2, 4, 7, 9, 1, 8, null, null, 6};
        BinaryTree bt = new BinaryTree(nums);
        SumRootToLeaf129 srt = new SumRootToLeaf129();
        int sum = srt.sumNumbers(bt.getRoot());
        System.out.println("sum = " + sum);

    }

}

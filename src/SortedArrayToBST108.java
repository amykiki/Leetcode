/**
 * Created by Amysue on 2016/7/26.
 */
public class SortedArrayToBST108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return findMiddle(0, nums.length - 1, nums);
    }

    private TreeNode findMiddle(int low, int high, int[] nums) {
        if (low > high) {
            return null;
        }
        int middle = (high - low) / 2 + low;
        TreeNode head = new TreeNode(nums[middle]);
        TreeNode leftNode = findMiddle(low, middle - 1, nums);
        TreeNode rightNOde = findMiddle(middle + 1, high, nums);
        head.left = leftNode;
        head.right = rightNOde;
        return head;
    }

    public static void main(String[] args) {
        SortedArrayToBST108 st = new SortedArrayToBST108();
//        int[] nums = {1,2,3,4,5,6,7,8,9};
//        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[] nums = {};
        TreeNode root = st.sortedArrayToBST(nums);
        System.out.println(1);
    }
}

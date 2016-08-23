/**
 * Created by Amysue on 2016/8/23.
 */
public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        int Max  = nums[0];
        int lsum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                if (lsum < 0) {
                    lsum = nums[i];
                } else {
                    lsum += nums[i];
                }
            } else {
                if (lsum <= nums[i]) {
                    lsum = nums[i];
                } else {
                    lsum += nums[i];
                }
            }
            if (lsum > Max) {
                Max = lsum;
            }
        }
        return Max;
    }

    public static void main(String[] args) {
        MaxSubArray53 ms   = new MaxSubArray53();
//        int[]         nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2, 4, -3, 4, 2};
//        int[] nums = {4, -2, 1};
//        int[] nums = {4, -2, 1, 6, 4};
//        int[] nums = {-9, -8, -7, -6, -5, -4};
//        int[] nums = {9, 8, -10, 6, 5, 4};
        int[] nums = {22, -10, 20};
        int max = ms.maxSubArray(nums);
        System.out.println("max = " + max);
    }
}

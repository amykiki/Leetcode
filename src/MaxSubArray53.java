/**
 * Created by Amysue on 2016/8/23.
 */
public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        int Max  = nums[0];
        int p = 0;
        while (p < nums.length && nums[p] <= 0) {
            if (nums[p] > Max) {
                Max = nums[p];
            }
            p++;
        }
        if (p < nums.length) {
            int lsum = nums[p];
            Max = lsum;
            p++;
            for (int i = p; i < nums.length; i++) {
                if (nums[i] <= 0) {
                    lsum += nums[i];
                    continue;
                }
                if (lsum > 0) {
                    lsum += nums[i];
                } else {
                    lsum = nums[i];
                }
                if (lsum > Max) {
                    Max = lsum;
                }
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
        int[] nums = {9, 8, -20, 6, 5, 4};
//        int[] nums = {22, -10, 20};
        int max = ms.maxSubArray(nums);
        System.out.println("max = " + max);
    }
}

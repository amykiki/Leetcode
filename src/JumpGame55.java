import java.util.*;

/**
 * Created by Amysue on 2016/8/25.
 */
public class JumpGame55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int   N       = nums.length - 1;
        int[] results = new int[2];
        results[0] = 0;
        results[1] = nums[0];
        if (nums[0] >= N) {
            return true;
        }
        int rc = 0;
        while (true) {
            rc = jump(nums, results, N);
            if (rc != 0) {
                break;
            }
        }
        return rc > 0 ? true : false;
    }

    private int jump(int[] nums, int[] results, int N) {
        int low  = results[0];
        int high = results[1];
        int max  = high;
        for (int i = high; i > low; i--) {
            int maxI = nums[i] + i;
            if (maxI >= N) {
                return 1;
            }
            if (maxI > max) {
                max = maxI;
            }
        }
        if (max == high) {
            return -1;
        } else {
            results[0] = high;
            results[1] = max;
            return 0;
        }
    }

    public static void main(String[] args) {
        JumpGame55 jg = new JumpGame55();
//        int[]      nums = {3, 2, 1, 0, 4};
//        int[]      nums = {2,3,1,1,4};
        int[] nums = {2, 0, 3, 4, 4, 2, 3, 1, 4, 0};
//        int[]      nums = {2, 0};
//        int[]      nums = {3, 5, 1, 1, 1, 5, 0, 3, 4, 2};
        System.out.println(jg.canJump(nums));
        /*Random rand  = new Random();
        int    n     = 10;
        int[]  nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = rand.nextInt(6);
            if (i == 0) {
                nums2[i]++;
            }
        }
        System.out.println(Arrays.toString(nums2));*/
    }
}

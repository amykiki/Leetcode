import java.util.*;

/**
 * Created by Amysue on 2016/8/25.
 */
public class JumpGame55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        queue.push(0);
        while (!queue.isEmpty()) {
            if (jump(nums, queue, list)) {
                return true;
            }
            queue = list;
            list = new LinkedList<>();
        }

        return false;
    }

    private boolean jump(int[] nums, LinkedList<Integer> queue, LinkedList<Integer> list) {
        int                 max  = queue.peek();
        while (!queue.isEmpty()) {
            int i     = queue.pop();
            int maxI  = nums[i] + i;
            if (maxI >= nums.length - 1) {
                return true;
            }
            int count = maxI - max;
            if (count > 0) {
                max = maxI;
                int j = i + 1 + nums[i] - count;
                while (j <= maxI) {
                    list.push(j);
                    j++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame55 jg   = new JumpGame55();
//        int[]      nums = {3, 2, 1, 0, 4};
//        int[]      nums = {2,3,1,1,4};
//        int[]      nums = {2, 0, 3, 4, 4, 2, 3, 1, 4, 0};
        int[]      nums = {3, 5, 1, 1, 1, 5, 0, 3, 4, 2};
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

/**
 * Created by Amysue on 2016/8/17.
 */
public class JumpGame45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int[] ides = new int[nums.length];
        ides[0] = 0;
        boolean[] marked = new boolean[nums.length];
        marked[0] = true;
        int N     = nums.length - 1;
        int level = 0;
        int count = 1;
        int j     = 0;
        while (true) {
            int n         = j + count;
            int nextCount = 0;
            while (count > 0) {
                int numi = ides[j];
                for (int i = nums[numi]; i > 0; i--) {
                    if (numi + i >= N) {
                        return ++level;
                    }
                    if (!marked[numi + i]) {
                        marked[numi + i] = true;
                        ides[n++] = numi + i;
                        nextCount++;
                    } else {
                        break;
                    }
                }
                count--;
                j++;
            }
            count = nextCount;
            level++;
        }
    }

    public static void main(String[] args) {
        JumpGame45 jg = new JumpGame45();
//        int[]      nums = {2, 3, 1, 1, 4};
        int[] nums   = {3, 4, 3, 2, 5, 4, 3};
        int   result = jg.jump(nums);
        System.out.println("result = " + result);
    }

}

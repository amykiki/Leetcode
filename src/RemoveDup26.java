import java.util.Arrays;

/**
 * Created by Amysue on 2016/7/6.
 */
public class RemoveDup26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int fast;
        int slow = 0;
        for (fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == nums[slow]) {
                continue;
            }
            nums[++slow] = nums[fast];
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        RemoveDup26 removeDup26 = new RemoveDup26();
//        int nums[] = {1, 1, 1, 1, 1, 2, 3, 3, 4, 4, 5, 6, 6, 6, 6, 6};
//        int nums[] = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
//        int nums[] = {1, 1, 1, 1, 1};
        int nums[] = {0, 1, 1, 1, 1, 1};
        int length = removeDup26.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("length = " + length);
    }
}

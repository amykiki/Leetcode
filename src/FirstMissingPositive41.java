/**
 * Created by Amysue on 2016/8/13.
 */
public class FirstMissingPositive41 {
    /*这个题难点在理解题意，而不是算法*/
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) {
                continue;
            }
            if (nums[i] <= 0 || nums[i] > N) {
                continue;
            }
            int m = nums[i];
            nums[i] = 0;
            swap(nums, m, m - 1);
        }
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int m, int j) {
        int tmp = nums[j];
        nums[j] = m;
        if (tmp == j + 1 || tmp <= 0 || tmp > nums.length) {
            return;
        }
        swap (nums,tmp, tmp - 1);

    }

    public static void main(String[] args) {
        FirstMissingPositive41 fm = new FirstMissingPositive41();
//        int[] nums = {3, 7, 4, 6, 2, 1, 7, 6, -2};
        int[] nums = {3,4,-1,1};
        int first = fm.firstMissingPositive(nums);
        System.out.println("first = " + first);
    }
}

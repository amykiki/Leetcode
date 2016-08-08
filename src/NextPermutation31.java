import java.util.Arrays;

/**
 * Created by Amysue on 2016/8/7.
 */
public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }
        int N     = nums.length - 1;
        int large = N;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums[large]) {
                if (nums[i] == nums[large]) {
                    move(nums, i, large - 1);
                    large--;
                } else {
                    move(nums, i, N);
                    large = N;
                }
            } else {
                int target = nums[i];
                int index  = find(nums, i + 1, large, target);
                nums[i] = nums[index];
                nums[index] = target;
                break;
            }
        }
    }

    private int find(int[] nums, int low, int high, int target) {
        int middle = 0;

        while (low <= high) {
            middle = (high - low) / 2 + low;
            if (nums[middle] > target) {
                high = middle - 1;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                break;
            }
        }
        if (low > high) {
            return low;
        } else {
            while (nums[middle] == target) {
                middle++;
            }
            return middle;
        }
    }

    private void move(int[] nums, int start, int end) {
        if ((start + 1) <= end) {
            int origin = nums[start];
            for (int i = start + 1; i <= end; i++) {
                nums[i - 1] = nums[i];
            }
            nums[end] = origin;
        }
    }

    public static void main(String[] args) {
        NextPermutation31 np   = new NextPermutation31();
//        int[]             nums = {6, 2, 5, 5, 2, 4, 4, 3, 3, 1};
//        int[]             nums = {6, 2, 5, 5, 4, 4, 3, 3, 1};
//        int[]             nums = {1,5,1};
//        int[]             nums = {2,2,7,5,4,3,2,2,1};
//        int[] nums = {6, 6, 6, 6, 6};
        int[] nums = {1,2};
        System.out.println(Arrays.toString(nums));
        np.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Math.ceil(11.3));
        System.out.println(Math.ceil(-11.3));
        System.out.println(Math.floor(11.3));
        System.out.println(Math.floor(-11.3));
        System.out.println(Math.round(11.3));
        System.out.println(Math.round(-11.7));
    }
}

/**
 * Created by Amysue on 2016/7/12.
 */
public class FindMiniumSort154 {
    public int findMin(int[] nums) {
        int min  = Integer.MAX_VALUE;
        int low  = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (high - low + 1) / 2 + low;
            if (middle == high) {
                if (nums[low] <= nums[high]) {
                    min = nums[low];
                } else {
                    min = nums[high];
                }
                break;
            }
            int middleValue = nums[middle];
            int highValue   = nums[high];
            if (middleValue > highValue) {
                while (nums[middle] == nums[middle + 1]) {
                    middle++;
                }
                low = middle + 1;
            } else if (middleValue < highValue) {
                while (middle > low && nums[middle] == nums[middle - 1]) {
                    middle--;
                }
                if (middle == low) {
                    min = nums[low];
                    break;
                }
                high = middle;
            } else {
                if (nums[low] == nums[middle]) {
                    int i = middle + 1;
                    while (i < high && nums[i] == nums[middle]) {
                        i++;
                    }
                    if (i != high) {
                        low = i;
                        continue;
                    }
                    int j = low + 1;
                    while (j < middle && nums[j] == nums[middle]) {
                        j++;
                    }
                    low = j;
                }
                while (middle > low && nums[middle] == nums[middle - 1]) {
                    middle--;
                }
                if (middle == low) {
                    min = middleValue;
                    break;
                } else {
                    high = middle;
                }

            }
        }
        return min;
    }

    public static void main(String[] args) {
        FindMiniumSort154 fs = new FindMiniumSort154();
//                int[]             nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] nums = {1, 4, 5, 5, 5, 5, 5, 5, 5, 5};
//        int[] nums = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 1, 1, 1, 2, 3, 4, 5, 5, 5};
//        int[] nums = {7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6};
//        int[] nums = {8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7};
//        int[] nums = {9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8};
//        int[] nums = {10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0};
        int[] nums = {7, 7, 7, 8, 9, 1, 1, 2, 3, 4, 4, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
//        int[] nums = {8, 6};
//        int[] nums = {3, 1, 3, 3};
        int   min  = fs.findMin(nums);
        System.out.println("min = " + min);
    }
}

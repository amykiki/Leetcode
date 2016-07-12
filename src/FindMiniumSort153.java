/**
 * Created by Amysue on 2016/7/12.
 */
public class FindMiniumSort153 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int min  = Integer.MAX_VALUE;
        int low  = 0;
        int high = nums.length - 1;
        int middle;
        /*
        * min 0 ~ 1/2时，nums[middle] < nums[high],high = middle
        * min 0 ~ 1/4时，nums[middle] < nums[high],high = middle
        * min 1/4 ~ 1/2时，nums[middle] > nums[high],low = middle + 1
        * min 1/2 ~ 1时，nums[middle] > nums[high],low = middle + 1
        * min 3/4 ~ 1时，nums[middle] > nums[high],low = middle + 1
        * */
        while (low <= high) {
            middle = (high - low + 1) / 2 + low;
            if (nums[middle] == nums[high]){
                if (nums[low] <= nums[high]) {
                    min = nums[low];
                } else {
                    min = nums[high];
                }
                break;
            } else if (nums[middle] > nums[high]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        FindMiniumSort153 fm = new FindMiniumSort153();
//        int[]             nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] nums = {6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5};
//        int[] nums = {7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6};
//        int[] nums = {8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7};
//        int[] nums = {9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8};
//        int[] nums = {10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0};
//        int[] nums = {6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5};
        int[] nums = {8, 6};
        int min = fm.findMin(nums);
        System.out.println("min = " + min);
    }
}

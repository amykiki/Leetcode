import java.util.Arrays;

/**
 * Created by Amysue on 2016/7/15.
 */
public class SearchForRange034 {
    public int[] searchRange(int[] nums, int target) {
        int[] results = {-1, -1};
        if (nums.length == 0) {
            return results;
        }
        int low = 0;
        int high = nums.length -1;
        while (low <= high) {
            int middle = low + (high - low)/2;
            if (nums[middle] == target) {
                int left = middle - 1;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                int right = middle + 1;
                while (right < nums.length && nums[right] == target) {
                    right++;
                }
                return new int[]{left+1, right-1};
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        SearchForRange034 sf = new SearchForRange034();
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int[] nums = {9};
        int[] nums = {1, 1, 1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7};
        int target = 5;
        int[] results = sf.searchRange(nums, target);
        System.out.println(Arrays.toString(results));
    }
}

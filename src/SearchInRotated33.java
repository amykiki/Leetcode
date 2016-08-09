/**
 * Created by Amysue on 2016/8/9.
 */
public class SearchInRotated33 {
    public int search(int[] nums, int target) {
        int low = 0;
        int len = nums.length - 1;
        int high = len;
        while (low < high) {
            int middle = low + (high - low)/2;
            if (nums[high] > nums[middle]) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
//        System.out.println("low = " + low);
        if (nums[low] == target) {
            return low;
        } else if (nums[low] > target) {
            return -1;
        } else {
            if (nums[len] < target) {
                return find(nums, 0, low - 1, target);
            } else {
                return find(nums, low + 1, len, target);
            }
        }

    }

    private int find(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int middle = -1;
        while (low <= high) {
            middle = low + (high - low)/2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        SearchInRotated33 si = new SearchInRotated33();
        int[] nums = {1, 2, 3, 4, 5, 6, 8, 0};
//        int[] nums = {2, 4, 5, 6, 0,1};
        int target = -4;
        int result = si.search(nums, target);
        System.out.println("result = " + result);

    }
}

/**
 * Created by Amysue on 2016/7/15.
 */
public class SearchInput035 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low)/2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        SearchInput035 si = new SearchInput035();
//        int[] nums = {1,3,5,6};
        int[] nums = {6};
        int target = 5;
        int position = si.searchInsert(nums, target);
        System.out.println("position = " + position);
    }
}

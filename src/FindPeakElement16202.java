/**
 * Created by Amysue on 2016/7/16.
 */
public class FindPeakElement16202 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low)/2;
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length - 1 || nums[mid] > nums[mid+1])) {
                return mid;
            }

            if ( mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        FindPeakElement16202 fp = new FindPeakElement16202();
//        int[] nums = {1,2,5,6,4,5,3,7,8,9,10,11,12};
        int[] nums = {1,2,5,6,4,5,3,7,8,9};
        int index = fp.findPeakElement(nums);
        System.out.println("index = " + index);
    }
}

/**
 * Created by Amysue on 2016/7/15.
 */
public class FindPeakElement162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 0;
        }
        boolean last = true;
        boolean current;
        for(int i = 1; i < nums.length; i++) {
            current = nums[i] > nums[i - 1];
            if (!current) {
                if (last) {
                    return i-1;
                }
            }
            last = current;
        }
        return nums.length - 1;
    }

    public static void main(String[] args) {
        FindPeakElement162 fp = new FindPeakElement162();
//        int[] nums = {5,6,7,8,9,10,11,12};
        int[] nums = {1, 2, 3, 1};
        int peak = fp.findPeakElement(nums);
        System.out.println("peak = " + peak);
    }
}

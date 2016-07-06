/**
 * Created by Amysue on 2016/7/6.
 */
public class RemoveEle27 {
    public int removeElement(int[] nums, int val) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[low] == val) {
                while (high >= low) {
                    if (nums[high] != val) {
                        nums[low] = nums[high];
                        high--;
                        break;
                    }
                    high--;
                }
            }
            low++;
        }
        return (high + 1);
    }

    public static void main(String[] args) {
        RemoveEle27 removeEle27 = new RemoveEle27();
//        int[] nums = {3, 2, 2, 3, 4, 5, 3};
//        int[] nums = {3, 2, 2, 3, 3, 3, 3, 1, 3, 3, 3};
//        int[] nums = {4, 4, 4, 2, 2, 4};
        int[] nums = {};
        int val = 3;
        int length = removeEle27.removeElement(nums, val);
        System.out.println("length = " + length);
    }
}

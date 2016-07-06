/**
 * Created by Amysue on 2016/7/6.
 */
public class RemoveEle27 {
    /*
    * 比较了别人的算法，发现我的算法效率是最高的，值得鼓励。从头尾两端考虑，
    * 当nums[low] == val，考虑把尾部不等于val element 移上前。
    * 此时要特别注意high >= low，并且要考虑尾部元素也和val相等情况。此时就要
    * high--，直到找到不等的元素*/
    public int removeElement(int[] nums, int val) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[low] == val) {
                while (high >= low) {
                    if (nums[high] != val) {
                        nums[low] = nums[high--];
                        break;
                    }
                    high--;
                }
            }
            low++;
        }
        return (high + 1);
    }
    /*
    * 这个题还有另外一种解法是用两个游标i, j来记录，都从0开始，i为fast-runner,
    * j为slow-runner。i每次循环+1，如果遇到nums[i] != val，则nums[j]=nums[i];j++;。
    * 如果遇到nus[i] == val，则继续下一个循环。这种方式相比我自己的方式效率会差。因为
    * 这种方式会移动复制很多元素。每个不相等的元素都要移动复制。当数组内等于val的element
    * 太少的话，效率会很低
    **/

    public static void main(String[] args) {
        RemoveEle27 removeEle27 = new RemoveEle27();
//        int[] nums = {3, 2, 2, 3, 4, 5, 3};
        int[] nums = {3, 2, 2, 3, 3, 3, 3, 1, 3, 3, 3};
//        int[] nums = {4, 4, 4, 2, 2, 4};
//        int[] nums = {};
        int val = 3;
        int length = removeEle27.removeElement(nums, val);
        System.out.println("length = " + length);
    }
}

import java.util.Arrays;

/**
 * Created by Amysue on 2016/7/8.
 */
public class ThreeSumClose016 {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            result = twoSum(i + 1, nums.length - 1, nums, target, nums[i], result);
            if (result >= target) {
                break;
            }
        }

        return result;
    }

    private int twoSum(int low, int high, int[] nums, int target, int last, int lastResult) {
        if (low >= high) {
            return lastResult;
        }
        int right = high;
        int left = high;
        int result = nums[low] + last;
        boolean highChange = false;
        while (true) {
            int value = result + nums[high];
            /*System.out.println("last = " + last);
            System.out.println("low = " + low);
            System.out.println("highLeft = " + left);
            System.out.println("highRight = " + right);
            System.out.println("high = " + high);*/
            if (value < target) {
                while ((high+1) < nums.length && nums[high] == nums[high+1]) {
                    high++;
                }
                left = high;
                high = (right - high + 1)/2 + high;
                highChange = true;
            } else if (value > target) {
                while (high - 1 >= low) {
                    if (nums[high] == nums[high - 1]) {
                        high--;
                    } else {
                        break;
                    }
                }
                right = high;
                high = (high - low + 1)/2 + low;
                highChange = true;
            } else {
                result = value;
                break;
            }
            if (highChange && high == right) {
                int value1 = result + nums[left];
                int value2 = result + nums[right];
                result = getTarget(target, value1, value2);
                break;
            }
        }

        result = getTarget(target, result, lastResult);
        if (result == target) {
            return result;
        }
        while ((low+1) < nums.length) {
            if (nums[low] == nums[low + 1]) {
                low++;
            } else {
                break;
            }
        }
        if (low == nums.length - 1) {
            return result;
        } else {
            low++;
            return twoSum(low, right, nums, target, last, result);
        }
    }

    private int getTarget(int target, int val1, int val2) {
        if (val1 == Integer.MAX_VALUE) {
            return val2;
        } else if (val2 == Integer.MAX_VALUE) {
            return val1;
        }
        return Math.abs(target - val1) < Math.abs(target - val2) ? val1 : val2;
    }

    public static void main(String[] args) {
        ThreeSumClose016 tsc = new ThreeSumClose016();
//        int[]     nums   = {2, -1, 4, -1, 4, 5, -3};
//        int[]     nums   = {1, 1, -1, -1, 3};
//        int[]     nums   = {-3, -2, -5, 3, -4};
//        int[]     nums   = {-1, 2, 1, 4};
//        int target = -1;
//        int[] nums = {0,-16,-11,-4,6,20,-17,10,14,-11,-16,17,-14,-11,8,-4,0,-2,10,15,0,-2,-3,19,17,-18,8,-16,-4,-16,-20,16,-16,5,-3,-18,-12,-18,-9,11,3,-14,-18,8,11,-9,-1,6,1,-17,-9,-7,11,-10,18,-1,4,-8,1,-20,-19,-19,12,13,14,15,0,18,3,8,-4,18,-1,6,-19,-11,11,14,12,11,-15,2,4,-1,5,3,-17,15,-1,-15,3,16,-11,-14,14,4,-7,-20,-2,-14,-8,-12,-12,18,4,-12,16};
//        int target = -39;
//        int[] nums = {46,-80,39,81,-44,22,76,-65,-11,71,-93,0,22,-85,-6,-6,34,-22,33,80,-2,93,-58,-89,-72,19,-47,-30,-14,92,25,5,16,98,62,-26,-11,7,8,4,22,-11,9,-3,55,78,-24,-38,-43,-57,-46,-35,34,93,4,23,-86,61,-74,-18,91,8,-10,89,15,24,94,84,67,37,4,-30,-26,85,-21,95,64,26,49,27,25,91,42,-79,-83,-12,-41,9,0,-100,62,66,96,66,-72,-7,-76,82,38,-58};
//        int target = -89;
        int[] nums = {4,-94,-14,98,-54,-16,18,-24,47,-84,-57,81,-48,-64,-64,-42,-94,34,-55,-25,-78,25,-32,53,-6,75,-30,-81,-15,-61,36,12,70,36,-44,-100,-69,-50,-6,-45,5,75,-74,-80,-32,0,42,30,25,-36,-94,90,-92,28,8,43,59,15,-38,-55,-34,71,34,-87,100,-61,90,-88,56,-11,56,10,37,-80,-53,11,-56,-28,15,-82,36,-6,-25,-40,-43,78,72,-79,46,-50,59,-18,-76,37,61,-38,94,89,4,-32,46,11,30,92,-15,-7,-70,21,-72,36,8,95,-84,-54,-44,-68,-62,-39,-2,-100,-73,-23,-100,87,34,-69,-28,-78,-79,100,83,45,12,34,-15,-64,41,96,64,77,37,-74,40,9,48,75,42,74,-36,-1,41,71,-85,88,81,13,7,48,-3,-100,-99,13,-92,-94,95,-45,92,84,-14,25,34,11,-57,55,-16,77,-26,88,77,-12,41,-72,5,-75,-93,-14,70,-33,18,-52,-41,14,-18,18,48,98,19,-54,91,-11,95,-41,-84,57,95,1};
        int target = 69;
        int result = tsc.threeSumClosest(nums, target);
        System.out.println("result = " + result);
    }
}

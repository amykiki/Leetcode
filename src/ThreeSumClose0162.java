import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amysue on 2016/7/9.
 */
public class ThreeSumClose0162 {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 2; i++) {
            result = sum(i + 1, i, nums, target, result, map);
//            result = getTarget(target, result, sum);
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
            if (i == nums.length - 2) {
                break;
            }
//            if (result == target) {
            if (result == target) {
                break;
            }
        }

        return result;
    }

    private int sum(int low, int last, int[] nums, int target, int sum, Map<Integer, Integer> map) {
        int high = nums.length - 1;
        int lowLength = nums.length - 1;
        for(int i = low; i < nums.length - 1; i++) {
            int tsum = nums[last] + nums[i];
            if (map.containsKey(tsum)) {
                sum = getTarget(target, sum, map.get(tsum));
            } else {
                if (i + 1 <= high) {
                    int diff = target - tsum;
                    int[] results = findOne(i + 1, high, nums, diff);
                    System.out.println("i = " + i);
                    System.out.println("results[0] = " + results[0]);
                    int key = tsum;
                    tsum += results[0];
                    high = results[1];
                    sum = getTarget(target, sum, tsum);
                    map.put(key, sum);
                } else {
                    break;
                }
            }
            if (sum == target) {
                break;
            }
            while (i < lowLength && nums[i] == nums[i + 1]) {
                i++;
            }
            if (i == lowLength) {
                break;
            }



        }
        return sum;
    }

    private int[] findOne(int low, int high, int[] nums, int target) {
        if (low == high) {
            return new int[]{nums[low], low};
        }
        int resultHigh = high;
        int i = low;
        while (true) {
            int current = nums[i];
            if (current < target) {
                low = i;
                i = (high - i + 1)/2 + i;
                if (high == i) {
                    break;
                }

            } else if (current > target) {
                high = i;
                i = (i - low)/2 + low;
                if (low == i) {
                    break;
                }
            } else {
                return new int[]{current, i};
            }
        }
        if (nums[high] > target) {
            resultHigh = high;
        }
        if (nums[low] > target) {
            resultHigh = low;
        }
        /*System.out.println("nums[low] = " + nums[low]);
        System.out.println("nums[high] = " + nums[high]);*/
        int result = getTarget(target, nums[low], nums[high]);
        return new int[]{result, resultHigh};

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
        ThreeSumClose0162 tsc = new ThreeSumClose0162();
//        int[]     nums   = {2, -1, 4, -1, 4, 5, -3};
//        int[]     nums   = {2, 1, 4, 1, 4, 5, 3};
//        int[]     nums   = {1, 1, -1, -1, 3};
//        int[]     nums   = {-3, -2, -5, -3, -4};
//        int[]     nums   = {-1, 2, 1, 4};
//        int[] nums = {1, 1, 1, 1, 2, 3};
//        int target = 7;
        /*int[] nums = {0,-16,-11,-4,6,20,-17,10,14,-11,-16,17,-14,-11,8,-4,0,-2,10,15,0,-2,-3,19,17,-18,8,-16,-4,-16,-20,16,-16,5,-3,-18,-12,-18,-9,11,3,-14,-18,8,11,-9,-1,6,1,-17,-9,-7,11,-10,18,-1,4,-8,1,-20,-19,-19,12,13,14,15,0,18,3,8,-4,18,-1,6,-19,-11,11,14,12,11,-15,2,4,-1,5,3,-17,15,-1,-15,3,16,-11,-14,14,4,-7,-20,-2,-14,-8,-12,-12,18,4,-12,16};
        int target = -39;*/
        /*int[] nums = {46,-80,39,81,-44,22,76,-65,-11,71,-93,0,22,-85,-6,-6,34,-22,33,80,-2,93,-58,-89,-72,19,-47,-30,-14,92,25,5,16,98,62,-26,-11,7,8,4,22,-11,9,-3,55,78,-24,-38,-43,-57,-46,-35,34,93,4,23,-86,61,-74,-18,91,8,-10,89,15,24,94,84,67,37,4,-30,-26,85,-21,95,64,26,49,27,25,91,42,-79,-83,-12,-41,9,0,-100,62,66,96,66,-72,-7,-76,82,38,-58};
        int target = -89;*/
        /*int[] nums = {4,-94,-14,98,-54,-16,18,-24,47,-84,-57,81,-48,-64,-64,-42,-94,34,-55,-25,-78,25,-32,53,-6,75,-30,-81,-15,-61,36,12,70,36,-44,-100,-69,-50,-6,-45,5,75,-74,-80,-32,0,42,30,25,-36,-94,90,-92,28,8,43,59,15,-38,-55,-34,71,34,-87,100,-61,90,-88,56,-11,56,10,37,-80,-53,11,-56,-28,15,-82,36,-6,-25,-40,-43,78,72,-79,46,-50,59,-18,-76,37,61,-38,94,89,4,-32,46,11,30,92,-15,-7,-70,21,-72,36,8,95,-84,-54,-44,-68,-62,-39,-2,-100,-73,-23,-100,87,34,-69,-28,-78,-79,100,83,45,12,34,-15,-64,41,96,64,77,37,-74,40,9,48,75,42,74,-36,-1,41,71,-85,88,81,13,7,48,-3,-100,-99,13,-92,-94,95,-45,92,84,-14,25,34,11,-57,55,-16,77,-26,88,77,-12,41,-72,5,-75,-93,-14,70,-33,18,-52,-41,14,-18,18,48,98,19,-54,91,-11,95,-41,-84,57,95,1};
        int target = 69;*/
        /*int[] nums = {0, 2, 1, -3};
        int target = 1;*/
        /*int[] nums = {-7,-71,-7,-13,45,46,-50,83,-29,-72,9,32,-74,81,68,92,-31,28,-46,-86,-70,31,-62,-20,-56,97,-41,21,81,17,-14,56,69,16,25,-38,65,-48,15,16,-25,68,-41,46,-56,-2,-3,82,8,19,-32,62,92,-56,-9,43,50,100,66,-45,41,-24,-4,83,-36,79,24,97,82,89,-56,-91,75,-64,-68,96,-55,-52,-58,-37,68,27,89,-40,-42,94,-92,-70,40,74,75,-15,54,-54,0,4,-39,93,88,-31,-26,93,8,-85,-62,89,-93,98,4,-58,8,5,-93,7,30,-75,63,41,62,-52,49,93,-11,87,7,52,5,-96,-56,43,-41,-75,-16,73,6,35,-32,62,-50,-57,-25,5,-32,94,-70,6,19,-12,63,-47,76,-57,41,-49,-33,-15,-81,55,88,67,-51,100,-19,-39,62,84,-100,78,-24,31,-32,-83,33,-25,86,9,-30,-40,52,64,-30,-17,19,-69,-89,-67,-79,-100,-53};
        int target = 157;*/
        /*int[] nums = {-10, -4, 0, 1, 20};
        int target = 0;*/
        int[] nums = {43,75,-90,47,-49,72,17,-31,-68,-22,-21,-30,65,88,-75,23,97,-61,53,87,-3,33,20,51,-79,43,80,-9,34,-89,-7,93,43,55,-94,29,-32,-49,25,72,-6,35,53,63,6,-62,-96,-83,-73,66,-11,96,-90,-27,78,-51,79,35,-63,85,-82,-15,100,-82,1,-4,-41,-21,11,12,12,72,-82,-22,37,47,-18,61,60,55,22,-6,26,-60,-42,-92,68,45,-1,-26,5,-56,-1,73,92,-55,-20,-43,-56,-15,7,52,35,-90,63,41,-55,-58,46,-84,-92,17,-66,-23,96,-19,-44,77,67,-47,-48,99,51,-25,19,0,-13,-88,-10,-67,14,7,89,-69,-83,86,-70,-66,-38,-50,66,0,-67,-91,-65,83,42,70,-6,52,-21,-86,-87,-44,8,49,-76,86,-3,87,-32,81,-58,37,-55,19,-26,66,-89,-70,-69,37,0,19,-65,38,7,3,1,-96,96,-65,-52,66,5,-3,-87,-16,-96,57,-74,91,46,-79,0,-69,55,49,-96,80,83,73,56,22,58,-44,-40,-45,95,99,-97,-22,-33,-92,-51,62,20,70,90};
        int target = 284;
        int result = tsc.threeSumClosest(nums, target);
        System.out.println("result = " + result);
        /*Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int k = Arrays.binarySearch(nums, 0);
        System.out.println("k = " + k);
        if (k < 0) {
            k = -k - 1;
        }
        System.out.println("k = " + k);*/
    }
}

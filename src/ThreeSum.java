import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.Iterator;

public class ThreeSum {
    private static Random random;
    private static long seed;
    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        
        quickSort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return result;
        }
        int N = nums.length;
        int first = 0;
        int sec;
        int last;
        int third;
        int value;
        int low = N - 1;
        while (low >= 0 && nums[low] >= 0) {
            low--;
        }
        low++;
        while (first < N) {
            if (nums[first] > 0) break;
            sec = first + 1;
            third = N - 1;
            while (sec < N) {
                value = 0 - (nums[first] + nums[sec]);
                if (value < 0) break;
                int lt = low;
                if ((sec + 1) > low) {
                    lt = sec + 1;
                }
                int bound = N - 1;
                if (third >= 0) bound = third;
                third = search(nums, value, lt, bound);
                
                if ( third >= 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[sec]);
                    list.add(nums[third]);
                    result.add(list);
                }
                last = sec;
                sec++;
                while (sec < N && (nums[sec] == nums[last])) {
                    sec++;
                }
            }
            last = first;
            first++;
            while (first < N && (nums[first] == nums[last])) {
                first++;
            }
        }
        return result;
    }
    private void quickSort(int[] nums) {
        shuffle(nums);
        quickSort(nums, 0, nums.length - 1);
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private int search(int[]a, int k, int low, int high) {
        int result = -1;
        int mid;
        while (low <= high) {
            mid = (high - low)/2 + low;
            if (a[mid] == k) {
                return mid;
            }
            else if (a[mid] < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return result;
    }
    private void shuffle(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int j = i + uniform(N - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    private int uniform (int N) {
        if (N <= 0) throw new IllegalArgumentException("Parameters N must be positive");
        return random.nextInt(N);
    }
    private void quickSort(int[]a, int low, int high) {
        if (high <= low) return;
        int target = a[low];
        int li = low;
        int hi = high;
        int i = low + 1;
        while (i <= hi) {
            if (a[i] < target) {
                swap(a, i, li);
                i++;
                li++;
            }
            else if (a[i] > target) {
                swap(a, i, hi);
                hi--;
            }
            else {
                i++;
            }
        }
        quickSort(a, low, li - 1);
        quickSort(a, hi + 1, high);
    }
//    private void quickSort(int[]a, int low, int high) {
//        if (high <= low) return;
//        int target = a[low];
//        int i = low + 1;
//        int j = high;
//        while (i <= j) {
//            while (i <= high && a[i] <= target) {
//                i++;
//            }
//            while (a[j] > target) {
//                j--;
//            }
//            if (i < j) {
//                swap(a, i, j);
//                i++;
//                j--;
//            }
//        }
//        swap(a, low, j);
//        quickSort(a, low, j-1);
//        quickSort(a, j+1, high);
//    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ThreeSum ths = new ThreeSum();
//        int[] nums = new int[] {-1, -6, -1, 0, 7, 1, 0, -2, 8, 0, -4, 5, 2, 1, -1, 4};
//        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[] {10, 9, 1, 2};
        int[] nums = new int[] {0, 0, 0};
        List<List<Integer>> result = ths.threeSum(nums);
        System.out.println(Arrays.toString(nums));
        Iterator<List<Integer>> it = result.iterator();
        while (it.hasNext()) {
            List<Integer> sum = it.next();
            System.out.print("(");
            int j = 0;
            for (Integer i: sum) {
                System.out.print(i);
                j++;
                if (j != sum.size()) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
    }

}

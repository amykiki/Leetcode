import java.util.Arrays;
import java.util.Random;

/**
 * Created by Amysue on 2016/8/2.
 */
public class FindMedianSortedArrays04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        if (nums1.length == 0) {
            return median(nums2);
        }
        if (nums2.length == 0) {
            return median(nums1);
        }
        int len = nums1.length + nums2.length;
        int middle1 = (len - 1)/2;
        int middle2 = middle1;
        if (len % 2 == 0) {
            middle2 = middle1 + 1;
        }
        int low = 0;
        int high = nums2.length - 1;
        int middle = 0;
        int left1  = -1;
        int right1 = -1;
        int left2  = -1;
        int right2 = -1;
        while (low <= high) {
            middle = (high - low) /2 + low;
            int mv = nums2[middle];
            int n = Arrays.binarySearch(nums1, mv);
            if (n < 0) {
                n = 0 - n - 1;
            }
            int mn = n + middle;
            if (middle1 == middle2) {
                if (mn == middle1) {
//                    System.out.println("nums2[middle] = " + nums2[middle]);
                    return nums2[middle];
                } else {
                    if (mn > middle1) {
                        right1 = n - 1;
                        right2 = mn;
                        high = middle - 1;
                    } else {
                        left1 = n;
                        left2 = mn;
                        low = middle + 1;
                    }
                }
            } else {
                if (mn < middle1) {
                    left1 = n;
                    left2 = mn;
                    low = middle + 1;
                } else if (mn > middle2) {
                    right1 = n - 1;
                    right2 = mn;
                    high = middle - 1;

                } else {
                    if (mn == middle1) {
                        if (n == nums1.length) {
                            return (median(nums2[middle], nums2[middle + 1]));
                        } else if ((middle + 1) == nums2.length) {
                            return median(nums1[n], nums2[middle]);
                        } else {
                            return median(nums2[middle], Math.min(nums1[n], nums2[middle + 1]));
                        }
                    } else {
                        if (n == 0) {
                            return (median(nums2[middle], nums2[middle - 1]));
                        } else if (middle ==  0) {
                            return median(nums1[n-1], nums2[middle]);
                        } else {
                            return median(nums2[middle], Math.max(nums1[n-1], nums2[middle - 1]));
                        }
                    }
                }

            }
        }
        if (left2 != -1) {
            int n1 = middle1 - left2 + left1 - 1;
            if (middle1 == middle2) {
//                System.out.println("nums1[n1] = " + nums1[n1]);
                return nums1[n1];
            } else {
                return median(nums1[n1], nums1[n1 + 1]);
            }
        } else {
            int n1 = right1 - (right2 - middle1) + 1;
            if (middle1 == middle2) {
                return nums1[n1];
            } else {
                return median(nums1[n1], nums1[n1 + 1]);
            } 
        }
    }

    private double median(int a, int b) {
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
        return (a + b)/2.0;
    }
    private double median(int[] nums) {
        int middle = (nums.length - 1)/2;
        if (nums.length % 2 == 1) {
            return nums[middle];
        } else {
            return (nums[middle] + nums[middle+1])/2.0;
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays04 fm = new FindMedianSortedArrays04();
        Random r = new Random();
        int len1 = 10;
        int len2 = 8;
//        int[] nums1 = new int[len1];
//        int[] nums2 = new int[len2];
        /*for(int i = 0; i < len1; i++) {
            int num = r.nextInt(30) + 1;
            nums1[i] = num;
        }
        for(int i = 0; i < len2; i++) {
            int num = r.nextInt(30) + 1;
            nums2[i] = num;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);*/
//        nums1 = new int[]{5, 15, 20, 25, 26, 26, 27, 28, 29, 30};
//        nums2 = new int[]{39,40,48,50,55,56};
//        nums2 = new int[]{1,2,3,4,31,32,33,34};
//        nums1 = new int[]{1, 7, 9, 11, 15, 15, 16, 19, 21, 24};
//        nums2 = new int[]{1, 11, 15, 24, 24, 26, 27, 28};
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
//        System.out.println(Arrays.binarySearch(nums1, 4));
        System.out.println(fm.findMedianSortedArrays(nums1, nums2));
    }
}

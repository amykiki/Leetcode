import java.util.Arrays;

/**
 * Created by Amysue on 2016/7/7.
 */
public class MergeSortArray088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int k = length - 1;
        int i = m - 1;
        int j = n - 1;
        while (k >= 0 && i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 6, 7, 9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        int[] nums1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {2, 3, 4, 8};
        int m = 6;
        int n = 0;
        MergeSortArray088 mer = new MergeSortArray088();
        mer.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}

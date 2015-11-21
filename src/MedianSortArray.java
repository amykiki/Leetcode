public class MedianSortArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if ((total % 2) == 1) {
            return findKth(nums1, 0, nums2, 0, total/2 + 1)/1.0;
        }
        else {
            return (findKth(nums1, 0, nums2, 0, total/2) + findKth(nums1, 0, nums2, 0, total/2 + 1))/2.0;
        }
    }
    
    private int findKth(int[] nums1, int mStart, int[] nums2, int nStart, int k) {
        int m = nums1.length - mStart;
        int n = nums2.length - nStart;
        if (m > n) {
            return findKth(nums2, nStart, nums1, mStart, k);
        }
        if (m == 0) {
            return nums2[nStart + k - 1];
        }
        if (k == 1) {
            return min(nums1[mStart], nums2[nStart]);
        }
        
        int ia = min(k/2, m);
        int ib = k - ia;
        int n1 = ia - 1 + mStart;
        int n2 = ib - 1 + nStart;
        if (nums1[n1] < nums2[n2]) {
            return findKth(nums1,  mStart + ia, nums2, nStart, k - ia);
        }
        else if (nums1[n1] > nums2[n2]) {
            return findKth(nums1, mStart, nums2, nStart + ib, k - ib);
        }
        else {
            return nums1[n1];
        }
    }
    
    private int min(int val1, int val2) {
        if (val1 <= val2) {
            return val1;
        }
        else {
            return val2;
        }
    }
    public static void main(String[] args) {
        MedianSortArray msa = new MedianSortArray();
        int[] nums1 = {1, 2, 3, 4, 5, 10, 14};
        int[] nums2 = {6, 7, 8, 9, 12};
//        int[] nums1 = {100001};
//        int[] nums2 = {100001};
        double ret = msa.findMedianSortedArrays(nums1, nums2);
        System.out.println("ret = " + ret);

    }

}

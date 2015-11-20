public class MedianSortArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0;
        int length = nums1.length + nums2.length;
        int[] nums0 = new int[length - 1];
        int index0 = 0;
        int median0Index = (length - 1) / 2;
        int isOdd = (length) % 2;
        int low1 = 0;
        int high1 = nums1.length - 1;
        int low2 = 0;
        int high2 = nums2.length - 1;
        int median1 = 0;
        int median2 = 0;
        int find = 0;
        while ((find == 0) && (low1 <= high1)) {
            int median1Index = (low1 + high1) / 2;
            median1 = nums1[median1Index];
            int index = binarySearch(median1, nums2, low2, high2);
            if (index == 0) {
                
            }
            else if (index == nums2.length) {
                
            }
            index0 = median1Index + index;
            if (index0 == median0Index) {
                if (isOdd == 1) {
                    median = (double) median1;
                }
                else {
                    int value1 = nums1[median1Index + 1];
                    int value2 = 0;
                    if (index < nums2.length) {
                        value2 = nums2[index];
                    }
                    if (value1 <= value2) {
                        median = ((double) median1 + value1) / 2.0;
                    }
                    else {
                        median = ((double) median1 + value2) / 2.0;
                    }
                }
                find = 1;
            }
            else if (index0 < median0Index) {
                low1 = median1Index + 1;
            }
            else {
                high1 = median1Index - 1;
            }
        }
        return median;
    }
    
    public int binarySearch(int value, int[] arr, int low, int high) {
        int index = 0;
        while (low <= high) {
            int medianIndex =  (low + high) / 2;
            int median = arr[medianIndex];
            if (value > median) {
                low = medianIndex + 1;
            }
            else if (value < median) {
                high = medianIndex - 1;
            }
            else {
                index = medianIndex  + 1;
                break;
            }
        }
        if (low > high) {
            index = low;
        }
        return index;
    }
    public static void main(String[] args) {
        MedianSortArray msa = new MedianSortArray();
        int[] nums2 = {3, 5, 7, 9, 12};
        int low = 0;
        int high = 4;
        int value = 5;
        int ret = msa.binarySearch(value, nums2, low, high);
        System.out.println("ret = " + ret);

    }

}

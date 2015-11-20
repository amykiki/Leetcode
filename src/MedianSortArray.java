public class MedianSortArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0;
        int medianCurrent = -1;
        int medianNext = -1;
        int length = nums1.length + nums2.length;
        int index0 = 0;
        int median0Index = (length - 1) / 2;
        int isOdd = (length) % 2;
        int low1 = 0;
        int high1 = nums1.length - 1;
        int low2 = 0;
        int high2 = nums2.length - 1;
        int index2 = 0;
        int median1 = 0;
        int find = 0;
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        else if (nums1.length == 0) {
            int value1 = nums2[high2/2];
            int value2 = value1;
            if (isOdd == 0) {
                value2 = nums2[high2/2 + 1];
            }
            median = ((double) value1 + value2) / 2.0;
            return median;
        }
        else if (nums2.length == 0) {
            int value1 = nums1[high1/2];
            int value2 = value1;
            if (isOdd == 0) {
                value2 = nums1[high1/2 + 1];
            }
            median = ((double) value1 + value2) / 2.0;
            return median;
        }
        while (find == 0 && low1 <= high1) {
            int median1Index = (low1 + high1) / 2;
            median1 = nums1[median1Index];
            index2 = binarySearch(median1, nums2, low2, high2);
            index0 = median1Index + index2;
            if (index0 == median0Index) {
                medianCurrent = median1;
                find = 1;
                if (isOdd == 0) {
                    int value1 = 0;
                    int value2 = 0;
                    if ((median1Index + 1) < nums1.length) {
                        value1 = nums1[median1Index + 1];
                        if (index2 < nums2.length) {
                            value2 = nums2[index2];
                            if (value1 <= value2) {
                                medianNext = value1;
                            }
                            else {
                                medianNext = value2;
                            }
                        }
                        else {
                            medianNext = value1;
                        }
                    }
                    else {
                        medianNext = nums2[index2];
                    }
                }
            }
            else if (index0 < median0Index) {
                low1 = median1Index + 1;
                low2 = index2;
            }
            else {
                if (index0 == (median0Index + 1)) {
                    medianNext = median1;
                }
                high1 = median1Index - 1;
                high2 = index2 - 1;
            }
        }
        
        
        if (find == 0) {
            if (index0 < median0Index) {
                index2 = index2 + (median0Index - index0) - 1;
            }
            else {
                index2 = index2 - (index0 - median0Index);
            }
            
            medianCurrent = nums2[index2];
        }
        
        if (isOdd == 1) {
            median = (double) medianCurrent;
        }
        else {
            if (medianNext == -1) {
                medianNext = nums2[index2+1];
            }
            median = ((double) medianCurrent + medianNext) / 2.0;
        }
        return median;
    }
    
    private int binarySearch(int value, int[] arr, int low, int high) {
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
//        int[] nums1 = {1, 2, 3, 4, 5, 7, 12};
//        int[] nums2 = {6, 8, 9, 10, 14};
        int[] nums1 = {0};
        int[] nums2 = {1};
        double ret = msa.findMedianSortedArrays(nums1, nums2);
        System.out.println("ret = " + ret);

    }

}

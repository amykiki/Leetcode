public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k <= 0) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int len = nums.length;
        int cmp = len % k;
        int num = 1;
        if (cmp == 0) {
            num = k;
        } else if ( (k > len /2) && (len % cmp) == 0) {
            num = cmp;
        }
        int nextVal;
        int lastVal;
        int next;
        for(int i = 0; i < num; i++) {
            next = (i + k) % len;
            lastVal = nums[i];
            while (true) {
                nextVal = nums[next];
                nums[next] = lastVal;
                lastVal = nextVal;
                next = (next + k) % len;
                if (next == i) {
                    nums[i] = lastVal;
                    break;
                }
            }
        }
    }

    private void shiftArray(int start, int target, int len, int[] nums) {
        for(int i = 0; i < len; i++) {
            nums[target + i] = nums[start + i];
        }
    }
    public static void main(String[] args) {
        RotateArray189 ra = new RotateArray189();
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 4;
//        int[] nums = {1, 2};
//        int k = 1;
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int k = 5;
        /**
         * 右移7位
         * 5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3, 4
         * 0 -> 7 -> 2 -> 9 -> 4 -> 11 -> 6 -> 1 -> 8 -> 3 -> 10 -> 5 -> 0
         * 右移4位
         * 0 -> 4 -> 2 -> 0
         * 1 -> 5 -> 3 -> 1
         * 右移2位
         * 0 -> 2 -> 4 -> 0
         * 1 -> 3 -> 5 -> 1
         *
         */


        ra.rotate(nums, k);
        System.out.println(CommonUtil.printArray(nums));
    }
}

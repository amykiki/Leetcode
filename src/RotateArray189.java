public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k <= 0) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int N = nums.length;
        int[] copy;

        if (k < N - k) {
            copy = new int[k];
            System.arraycopy(nums, N - k, copy, 0, k);
            for(int i = N - k - 1 ; i >= 0; i--) {
                nums[i + k] = nums[i];
            }
            System.arraycopy(copy, 0, nums, 0, k);
        }else {
            copy = new int[N - k];
            System.arraycopy(nums, 0, copy, 0, N - k);
            for(int i = N - k; i < N; i++) {
                nums[i - (N - k)] = nums[i];
            }
            System.arraycopy(copy, 0, nums, k, N - k);
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
//        int k = 0;
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 4;
        ra.rotate(nums, k);

    }
}

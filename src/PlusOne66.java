import java.util.Arrays;

/**
 * Created by Amysue on 2016/7/6.
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        int[] results = digits;
        int   j       = digits.length - 1;
        int   value;
        while (j >= 0) {
            value = digits[j] + 1;
            if (value < 10) {
                digits[j] = value;
                break;
            } else {
                digits[j] = 0;
                j--;
            }
        }
        if (j < 0) {
            results = new int[digits.length + 1];
            results[0] = 1;
            for (j = 1; j < results.length; j++) {
                results[j] = digits[j - 1];
            }
        }
        return results;
    }

    public static void main(String[] args) {
        PlusOne66 plusOne66 = new PlusOne66();
        int[]     nums      = {};
        int[]     result    = plusOne66.plusOne(nums);
        System.out.println(Arrays.toString(result));
    }
}

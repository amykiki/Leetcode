import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Amysue on 2016/9/24.
 */
public class SortColors75 {
    public void sortColors(int[] nums) {
        if(nums == null) return;
        int lt = -1;
        int gt = nums.length - 1;
        int i = 0;
        int red = 0;
        int white = 1;
        int blue = 2;
        while (i <= gt) {
            if (nums[i] < white) {
                nums[i++] = white;
                nums[++lt] = red;
            } else if (nums[i] > white) {
                nums[i] = nums[gt];
                nums[gt] = blue;
                gt--;
            } else {
                i++;
            }
        }
        return;
    }

    public static void main(String[] args) {
        SortColors75 sc = new SortColors75();
        int len = 10;
        Random rand = new Random();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++) {
            nums[i] = rand.nextInt(3);
        }
        System.out.println(Arrays.toString(nums));
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

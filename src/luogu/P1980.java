package luogu;

import utils.CommonUtil;

import java.util.Scanner;

public class P1980 {
    public static void main(String[] args) {
//        String data = "1000000 2";
//            String data = "9876543 2";
//        Scanner cin = new Scanner(data);
        Scanner cin=new Scanner(System.in);
        int N = cin.nextInt(), x = cin.nextInt();
        int length = 1;
        int tempN = N;
        while ((tempN = tempN / 10) != 0) {
            length++;
        }
        if (length == 1) {
            if (x == 0) {
                System.out.println(0);
            }
            System.out.println(1);
        }
        int[] nums = new int[length];
        int[] steps = new int[length];
        int[] results = new int[length];
        int step = 1;
        for(int i = 0; i < length; i++) {
            steps[i] = step;
            step *= 10;
        }
        tempN = N;
        for(int i = length - 1; i >= 0; i--) {
            nums[i] = tempN / steps[i];
            tempN = tempN % steps[i];
        }
        CommonUtil.printArray(nums);
        CommonUtil.printArray(steps);
        //计算最高位
        int left = N - nums[length - 1] * steps[length - 1];
        if (nums[length - 1] < x) {
            results[length - 1] = 0;
        } else if (nums[length - 1] == x) {
            results[length - 1] = left + 1;
        } else {
            results[length - 1] = steps[length - 1];
        }
        for(int i = 0; i < length - 1; i++) {
            int result = N / steps[i];
            int r1 = result / 10;
            int r2 = result % 10;
            results[i] = r2 >= x ? (r1 + 1) * steps[i] : r1 * steps[i];
        }
        CommonUtil.printArray(results);
        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += results[i];
        }
        System.out.println(sum);
    }


}

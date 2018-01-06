package luogu;

import utils.CommonUtil;

import java.util.Scanner;

public class P1980 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int N = cin.nextInt(), x = cin.nextInt();
        int length = 1;
        int tempN = N;
        while ((tempN = tempN / 10) != 0) {
            length++;
        }
        int[] nums = new int[length];
        int[] steps = new int[length];
        int[] results = new int[length];
        int step = 1;
        tempN = N;
        for(int i = 0; i < length; i++) {
            nums[i] = tempN % 10;
            tempN = tempN/10;
            steps[i] = step;
            step *= 10;
        }
//        CommonUtil.printArray(nums);
//        CommonUtil.printArray(steps);
        tempN = N;
        int last = 0;
        for(int i = 0; i < length; i++) {
            int r1 = tempN % 10;
            tempN = tempN / 10;
            int r2 = tempN;
            int count;
            int remain = 0;
            if (x == 0) {
                count = r2;
            }else {
                if (r1 > x) {
                    count = 1 ;
                } else if (r1 < x) {
                    count = 0;
                }else {
                    count = 0;
                    if (i == 0) {
                        remain = 1;
                    }else {
                        remain = last + 1;
                    }
                }
                if (r2 > 0) {
                    count += r2;
                }
            }
            results[i] = count * steps[i] + remain;
            last += r1*steps[i];
        }
//        CommonUtil.printArray(results);
        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += results[i];
        }
        System.out.println(sum);
    }
}

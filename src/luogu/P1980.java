package luogu;

import utils.CommonUtil;

import java.util.Scanner;

public class P1980 {
    /**
     * 该题的解法是分别计算输入的数字在每位上出现的个数，把每位上出现的次数相加，即为总次数
     * 每位出现的次数计算见下
     * 如727 7
     * 个位7: 727/10 + 1 = 73
     * 十位7: 72/10*10 = 70
     * 百位7: 7/10 + 28 = 28
     * 总次数为73 + 70 + 28 = 171
     * @param args
     */
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
        CommonUtil.printArray(nums);
        CommonUtil.printArray(steps);
        tempN = N;
        int last = 0;
        for(int i = 0; i < length; i++) {
            // r1表示剩余的个位
            int r1 = tempN % 10;
            tempN = tempN / 10;
            // r2表示高位的倍数
            int r2 = tempN;
            int count = 0;
            int remain = 0;
            //本来对r2 > 0的情况，count都应该为 r2 - 1，但是因为对于非0的数来说，在低位已经存在1个了所以为r2 - 1 + 1 = r2
            if (r2 > 0) {
                if (x == 0) {
                    count += (r2 - 1);
                }else {
                    count += r2;
                }
            }
            //如果X == 0，在某位上以0开头的数字不存在的，所以要排除掉
            if (r1 > x) {
                if(x > 0 || (x == 0 && r2 > 0))
                count = 1 ;
            } else if (r1 == x) {
                //如果r1 == x,则说明对该位以下的计算不能直接乘以10那么简单，而是看剩下多少数字
                //如727，对于百位7而言，以7开头的只有 700 ~ 727总共28个数字，而不是100个
                if(x > 0 || (x == 0 && r2 > 0))
                remain = last + 1;
            }
            results[i] = count * steps[i] + remain;
            last += r1*steps[i];
        }
        CommonUtil.printArray(results);
        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += results[i];
        }
        System.out.println(sum);
    }
}

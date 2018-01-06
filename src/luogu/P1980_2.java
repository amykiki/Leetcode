package luogu;

import java.util.Scanner;

public class P1980_2 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int N = cin.nextInt(), x = cin.nextInt();

        int otherCount = 0;
        for(int i = 1; i<= N; i++) {
            otherCount += numCount(i, x);
        }
        System.out.println("otherCount = " + otherCount);
    }
    public static int numCount(int i, int num) {
        int sum = 0;
        while (i != 0) {
            int r = i % 10;
            if (r == num) {
                sum++;
            }
            i =  i/10;
        }
        return sum;
    }
}

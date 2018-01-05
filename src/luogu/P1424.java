package luogu;

import java.util.Scanner;

public class P1424 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int a = cin.nextInt();
        long b = cin.nextLong();
        int step = 250;
        int i = 0;
        long sum = 0 ;
        while (i < b) {
            if (a != 6 && a != 7) {
                sum += step;
            }
            a += 1;
            if (a == 8) {
                a = 1;
            }
            i++;
        }
        System.out.println(sum);
    }
}

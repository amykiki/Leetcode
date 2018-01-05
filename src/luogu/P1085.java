package luogu;

import java.util.Scanner;

public class P1085 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int unhappyDay = 0;
        int unhappyHour = 0;
        int a = 0;
        int b = 0;
        int sum = 0;
        int i = 0;
        while (i < 7) {
            i++;
            a = cin.nextInt();
            b = cin.nextInt();
            sum = a + b - 8;
            if (sum > unhappyHour) {
                unhappyHour = sum;
                unhappyDay = i;
            }
        }
        System.out.println(unhappyDay);
    }
}

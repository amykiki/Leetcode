package luogu;

import java.util.Scanner;

public class P1422 {
    public static double LOWFEE = 0.4463;
    public static double MIDFEE = 0.4663;
    public static double HIGHFEE = 0.5663;
    public static double LOWSUM = 150 * LOWFEE;
    public static double MIDSUM = LOWSUM + 250 * MIDFEE;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt();
        double sum = 0;
        if (a <= 150) {
            sum = a * LOWFEE;
        } else if (a <= 400) {
            sum = LOWSUM + (a - 150) * MIDFEE;
        } else {
            sum = MIDSUM + (a - 400) * HIGHFEE;
        }
        System.out.printf("%.1f", sum);
    }
}

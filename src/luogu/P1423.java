package luogu;

import java.util.Scanner;

public class P1423 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        double a = cin.nextDouble();
        int i = 0;
        double sum = 0;
        double step = 2;
        while (sum < a) {
            sum += step;
            step *= 0.98;
            i++;
        }
        System.out.println(i);
    }
}

package luogu;

import java.util.Scanner;

public class P1425 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt(), b = cin.nextInt(), c = cin.nextInt(), d = cin.nextInt();
        int hour = 0;
        int min = 0;
        if (d < b) {
            d += 60;
            c -= 1;
        }
        hour = c - a;
        min = d - b;
        System.out.println(hour + " " + min);
    }
}

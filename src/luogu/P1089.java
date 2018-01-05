package luogu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1089 {
    public static void main(String[] args) {
        Scanner cin = null;
        try {
            cin = new Scanner(new File("D:\\codeproject\\githubProject\\Leetcode\\src\\luogu\\data\\P1089_1.dat"));
        } catch (FileNotFoundException e) {
        }
//        Scanner cin = new Scanner(System.in);
        int i = 0;
        int last = 0;
        int save = 0;
        int month = 300;
        boolean result = true;
        while (i < 12) {
            i++;
            int budget = cin.nextInt();
            int sum = last + month;
            if (sum < budget) {
                System.out.println("-" + i);
                result = false;
                break;
            }
            int p = (sum - budget) / 100 * 100;
            last = (sum - budget - p);
            save += p;
        }
        if (result) {
            System.out.printf("%.0f", save*1.2 + last);
        }
    }
}

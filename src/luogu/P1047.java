package luogu;

import utils.CommonUtil;

import java.util.Scanner;

public class P1047 {
    public static void main(String[] args) {
        String data = "500 3\n" +
                      "150 300\n" +
                      "100 200\n" +
                      "470 471\n";
        Scanner cin = new Scanner(data);
//        Scanner cin = new Scanner(System.in);
        int L = cin.nextInt();
        int M = cin.nextInt();
        int sum = 0;
        int[] trees = new int[L+1];
        for(int i = 0; i < M; i++) {
            int low = cin.nextInt();
            int high = cin.nextInt();
            while (low <= high) {
                if (trees[low] == 0) {
                    trees[low] = 1;
                    sum++;
                }
                low++;
            }

        }
        System.out.println(L - sum + 1);
    }


}

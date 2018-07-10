package luogu;

import utils.CommonUtil;

import java.util.Scanner;

public class P1046 {
    public static void main(String[] args) {
        String data = "100 200 150 140 129 134 167 198 200 111 110";
        Scanner cin = new Scanner(data);
//        Scanner cin = new Scanner(System.in);
        int[] heights = new int[10];
        for(int i = 0; i < 10; i++) {
            heights[i] = cin.nextInt();
        }
        int stand = cin.nextInt() + 30;
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            if (heights[i] <= stand) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}

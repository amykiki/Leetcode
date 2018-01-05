package luogu;

import java.util.Scanner;

public class P1421 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt(), b = cin.nextInt();
        int singlePen = 19;
        int cashSum = a * 10 + b;
        int count = cashSum / singlePen;
        System.out.println(count);
        System.out.println(Integer.MAX_VALUE);
        double c = 10E9;
        System.out.println(c);
        System.out.println(Long.MAX_VALUE - c);
    }
}


/*import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws Exception {
        Scanner cin=new Scanner(System.in);
        int a = cin.nextInt(), b = cin.nextInt();
        System.out.println(a+b);
    }
}*/

package luogu;

import java.util.Scanner;

public class P1909 {
    public static void main(String[] args) {
        String data = "57 2 2 50 30 30 27";
        Scanner scanner = new Scanner(data);
//        Scanner scanner = new Scanner(System.in);
        int buyCount = scanner.nextInt();
        int numA = scanner.nextInt();
        int priceA = scanner.nextInt();
        int numB  = scanner.nextInt();
        int priceB = scanner.nextInt();
        int numC = scanner.nextInt();
        int priceC = scanner.nextInt();

        if (numA == numB && numA == numC) {
            System.out.println(getCost(buyCount, numA, minThree(priceA, priceB, priceC)));
            return;
        }

        if (numB == numC) {
            int costA = getCost(buyCount, numA, priceA);
            int costOther = getCost(buyCount, numB, minTwo(priceB, priceC));
            System.out.println(costA < costOther ? costA : costOther);
            return;
        }

        int costA = getCost(buyCount, numA, priceA);
        int costB = getCost(buyCount, numB, priceB);
        int costC = getCost(buyCount, numC, priceC);
        System.out.println(minThree(costA, costB, costC));

    }

    public static int getCost(int buyCount, int num, int price) {
        int remain = buyCount % num;
        int count = remain == 0 ? buyCount/num : buyCount/num + 1;
        return count * price;
    }

    public static int minThree(int pricea, int priceb, int pricec) {
        int min = pricea < priceb ? pricea : priceb;
        min = min < pricec ? min : pricec;
        return min;
    }

    public static int minTwo(int price1, int price2) {
        return price1 <= price2 ? price1 :price2;
    }


}

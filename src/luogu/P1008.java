package luogu;

public class P1008 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for(int i = 1; i <= 3; i++) {
            arr[i] = 1;
            for(int j = 1; j <= 9; j++) {
                if (i == 3 && j > 3) {
                    break;
                }
                if (arr[j] != 0) {
                    continue;
                }
                arr[j] = 1;
                for(int k = 1; k <= 9; k++) {
                    if (arr[k] != 0) {
                        continue;
                    }
                    arr[k] = 1;
                    calc(i, j, k, arr);
                    arr[k] = 0;
                }
                arr[j] = 0;
            }
            arr[i] = 0;
        }
    }

    public static void calc(int a, int b, int c, int[] arr) {
        int[] brr = new int[arr.length];
        System.arraycopy(arr, 0, brr, 0, arr.length);
        int n1 = a * 100 + b * 10 + c;
        int n2 = n1 * 2;
        if (!check(n2, brr)) {
            return;
        }
        int n3 = n1 * 3;
        if (!check(n3, brr)) {
            return;
        }
        System.out.println(n1 + " " + n2 + " " + n3);
    }

    public static boolean check(int n, int[] arr) {
        int a = n /100;
        n = n % 100;
        int b = n/10;
        int c = n % 10;
        if (!checkNum(a, arr)) {
            return false;
        }
        if (!checkNum(b, arr)) {
            return false;
        }
        if (!checkNum(c, arr)) {
            return false;
        }
        return true;
    }

    public static boolean checkNum(int num, int[] arr) {
        if (num == 0) {
            return false;
        }
        if (arr[num] != 0) {
            return false;
        }
        arr[num] = 1;
        return true;
    }
}

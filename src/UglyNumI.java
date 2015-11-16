
public class UglyNumI {

    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        while (num != 0 && num != 1) {
            num = devide(num);
        }
        if (num == 1) {
            return true;
        }
        return false;
    }
    private int devide(int num) {
        if (num % 5 == 0) {
            return num / 5;
        }
        else if (num % 3 == 0) {
            return num / 3;
        }
        else if (num % 2 == 0) {
            return num / 2;
        }
        return 0;
    }
    public static void main(String[] args) {
        int num = 13;
        UglyNumI nu = new UglyNumI();
        if (nu.isUgly(num)) {
            System.out.println(num + " is ugly");
        }
        else {
            System.out.println(num + " is NOT ugly");
        }
    }

}

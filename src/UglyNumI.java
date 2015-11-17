
public class UglyNumI {

    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        else if (num == 0) {
            return false;
        }
        num = devide(num);
        if (num == 1) {
            return true;
        }
        return false;
    }
    private int devide(int num) {
        while (num % 5 == 0) {
            num = num / 5;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        return num;
    }
    public static void main(String[] args) {
        int num = 64;
        UglyNumI nu = new UglyNumI();
        if (nu.isUgly(num)) {
            System.out.println(num + " is ugly");
        }
        else {
            System.out.println(num + " is NOT ugly");
        }
    }

}

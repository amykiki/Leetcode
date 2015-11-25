
public class PalindromeNum {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        int reverse = 0;
        while (tmp > 0) {
            reverse = reverse*10 + tmp%10;
            tmp /= 10;
        }
        if (reverse == x) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PalindromeNum pn = new PalindromeNum();
        int x = 100001;
        boolean ret = pn.isPalindrome(x);
        if (ret) {
            System.out.println(x + " is palindrome");
        }
        else {
            System.out.println(x + " is Not palindrome");
        }
    }

}

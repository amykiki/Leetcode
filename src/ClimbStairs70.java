/**
 * Created by Amysue on 2016/9/15.
 */
public class ClimbStairs70 {
    public int climbStairs(int n) {
        int stairs = 0;
        if (n == 1) {
            return 1;
        }
        int last1 = 1;
        int last2 = 1;
        for (int i = 2; i <= n; i++) {
            stairs = last1 + last2;
//            System.out.println("i = " + i + ", stairs = " + stairs);
            last2 = last1;
            last1 = stairs;
        }
        return stairs;
    }

    public static void main(String[] args) {
        ClimbStairs70 cs = new ClimbStairs70();
        int           n  = 6;
        System.out.println(cs.climbStairs(n));
    }
}

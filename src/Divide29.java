/**
 * Created by Amysue on 2016/8/5.
 */
public class Divide29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == divisor) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        long dividendL = (long) dividend;
        long divisorL = (long) divisor;
        if (divisor == -1) {
            if (dividendL == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int)getPos(dividendL);
        }
        boolean negtive = false;
        if (dividendL < 0 && divisorL < 0) {
            negtive = false;
            dividendL = getPos(dividendL);
            divisorL = getPos(divisorL);
        } else {
            if (dividendL < 0) {
                negtive = true;
                dividendL = getPos(dividendL);
            }
            if (divisorL < 0) {
                negtive = true;
                divisorL = getPos(divisorL);
            }
        }
        int sum = 0;
        while (dividendL != 0) {
            long last = 0;
            long     n      = divisorL << 1;
            boolean gt     = false;
            int     result = 1;
            while (dividendL >= n) {
                result = result << 1;
                last = n;
                n = n << 1;
                gt = true;
            }
            if (gt) {
                dividendL -= last;
                sum += result;

            } else {
                if (dividendL >= divisorL) {
                    sum += result;
                }
                break;
            }
        }
        if (negtive) {
            return 0 - sum;
        }
        return sum;
    }

    private long getPos(long num) {
        return 0 - num;
    }


    public static void main(String[] args) {
        Divide29 d        = new Divide29();
//        int      dividend = Integer.MAX_VALUE;
        int      dividend = Integer.MIN_VALUE;
//        int      divisor  = 1073741824;
        int      divisor  = -3;
        int      result   = d.divide(dividend, divisor);
        System.out.println("result = " + result);
        long num = Integer.MIN_VALUE;
        System.out.println(0 - num);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println((Integer.MIN_VALUE - 1) << 2);
//        System.out.println((Integer.MIN_VALUE)/1073741824);
//        System.out.println((Integer.MIN_VALUE)/-1073741824);
//        System.out.println((Integer.MIN_VALUE)/-2);
//        System.out.println((Integer.MIN_VALUE)/-3);
//        System.out.println(Integer.MAX_VALUE/1073741824);
//        System.out.println(Integer.MAX_VALUE/-1073741824);
//        System.out.println(Integer.MAX_VALUE/-2);
//        System.out.println(Integer.MAX_VALUE/-3);
//        System.out.println(1073741823 << 1);
//        System.out.println(Integer.MAX_VALUE << 2);
//        System.out.println(Integer.toBinaryString(dividend));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE - 1);
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE - 1));
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//        System.out.println(Integer.toBinaryString(-1));
//        System.out.println(Integer.toBinaryString(-2));
//        String s = "1111111111111111111111111111110";
//        System.out.println(s.length());
//        System.out.println(Integer.toBinaryString(16));
//        System.out.println(Integer.toBinaryString(18));
//        System.out.println(Integer.toBinaryString(3));
    }
}

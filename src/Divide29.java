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
        if (divisor == -1) {
            return getPos(dividend);
        }
        int origian = dividend;
        boolean negtive = false;
        if (dividend < 0 && divisor < 0) {
            negtive = false;
            dividend = getPos(dividend);
            divisor = getPos(divisor);
        } else {
            if (dividend < 0) {
                negtive = true;
                dividend = getPos(dividend);
            }
            if (divisor < 0) {
                negtive = true;
                divisor = getPos(divisor);
            }
        }
        int sum = 0;
        boolean add = true;
        while (dividend != 0) {
            int last = 0;
            int     n      = divisor << 1;
            boolean gt     = false;
            int     result = 1;
            while (dividend >= n) {
                if (n <= divisor) {
                    break;
                }
                result = result << 1;
                last = n;
                n = n << 1;
                gt = true;
            }
            if (gt) {
                dividend -= last;
                sum += result;
                if (add && origian == Integer.MIN_VALUE) {
                    dividend++;
                    add = false;
                }

            } else {
                if (dividend >= divisor) {
                    sum += result;
                    dividend -= divisor;
                    if (add && origian == Integer.MIN_VALUE) {
                        dividend++;
                        add = false;
                        continue;
                    }
                }
                break;
            }
        }
        if (negtive) {
            return 0 - sum;
        }
        return sum;
    }

    private int getPos(int num) {
        if (num == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return 0 - num;
    }


    public static void main(String[] args) {
        Divide29 d        = new Divide29();
//        int      dividend = Integer.MAX_VALUE;
        int      dividend = Integer.MIN_VALUE;
//        int      divisor  = 1073741824;
        int      divisor  = -3;
        int      result   = d.divide(dividend, divisor);
//        System.out.println("result = " + result);
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
        System.out.println(1073741823 << 1);
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


public class ReverseInt {
    public int reverse(int x) {
        if (x == 0) return 0;
        int signal = 1;
        int bound = Integer.MAX_VALUE;  // this is import
        if (x < 0) {
            signal = -1;
            bound = Integer.MIN_VALUE;
        }
        int reverNum = 0;
        
        while (x != 0) {
            int i = x % 10;
            int j = (bound - i)/10;
            if (j*signal < reverNum*signal) { // this is import
                return 0;
            }
            reverNum = reverNum*10 + i;            
            x /= 10;
        }
        return reverNum;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseInt ri = new ReverseInt();
        int x = 1612345678;
        System.out.println(ri.reverse(x));

    }

}

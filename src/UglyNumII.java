public class UglyNumII {
    int count   = 0;
    int L1      = 2;
    int L1Index = 0;
    int L2      = 3;
    int L2Index = 0;
    int L3      = 5;
    int L3Index = 0;
    int[] uglys;
    int[] L1Uglys;
    int[] L2Uglys;
    int[] L3Uglys;
    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        uglys      = new int[n];
        L1Uglys    = new int[n];
        L2Uglys    = new int[n];
        L3Uglys    = new int[n];
        uglys[0]   = 1;
        count = 1;
        while (count < n) {
            int last = count - 1;
            L1Uglys[last] = uglys[last]*L1;
            L2Uglys[last] = uglys[last]*L2;
            L3Uglys[last] = uglys[last]*L3;
            int nextUglyNum = nextUgly();
            uglys[count] = nextUglyNum;
            count++;
        }
        return uglys[count-1];
    }
    
    private int nextUgly() {
        int L1Ugly = L1Uglys[L1Index];
        int L2Ugly = L2Uglys[L2Index];
        int L3Ugly = L3Uglys[L3Index];
        int min = 0;
        if (L1Ugly <= L2Ugly && L1Ugly <= L3Ugly) {
            min = L1Ugly;
        }
        else if (L2Ugly <= L1Ugly && L2Ugly <= L3Ugly) {
            min = L2Ugly;
        }
        else {
            min = L3Ugly;
        }
        if (min == L1Ugly) {
            L1Index++;
        }
        if (min == L2Ugly) {
            L2Index++;
        }
        if (min == L3Ugly) {
            L3Index++;
        }
        return min;
    }
    
    public static void main(String[] args) {
        int n = 400;
        UglyNumII unII = new UglyNumII();
        int nTh = unII.nthUglyNumber(n);
        System.out.println("the " + n + "th ugly number is " + nTh);

    }

}

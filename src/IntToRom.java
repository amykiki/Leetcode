
public class IntToRom {
    public String intToRoman(int num) {
        String result = "";
        if (num < 1 && num > 3999) return null;
        int index = 1;
        int base = 5;
        while (num > 0) {
            int remain = num % 10;
            num = num / 10;
            if (remain != 0) {
                int n = remain;
                remain = remain - base;
                result =  toRoman(remain, n, index) + result;
            };
            index += 2;
        }
        return result;
    }
    private String toRoman(int remain, int n, int index) {
        String[] romans = new String[] {"I", "V", "X", "L", "C", "D", "M", "NULL", "NULL"};
        String result = "";
        String forward = romans[index-1];
        String current = romans[index];
        String toward = romans[index+1];
        if (remain < 0) {
            if (n < 4) {
                result = cpyRoman(forward, n);
                
            }
            else {
                result = forward + current;
            }
        }
        else {
            if (remain < 4) {
                result = current + cpyRoman(forward, remain);
            }
            else {
                result = forward + toward;
            }
        }
        return result;
    }
    private String cpyRoman(String s, int times) {
        String result = "";
        while (times > 0) {
            result += s;
            times--;
        }
        return result;
    }

    public static void main(String[] args) {
        IntToRom itr = new IntToRom();
//        int num = 10;
        int num = Integer.parseInt(args[0]);
        String roman = itr.intToRoman(num);
        System.out.println(num + " to Roman is " + roman);

    }

}

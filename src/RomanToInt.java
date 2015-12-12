import java.util.TreeMap;

public class RomanToInt {
    public int romanToInt(String s) {
        int result = 0;
        char[] romans = s.toCharArray();
        TreeMap<Character, Integer> set = new TreeMap<>();
        set.put('I', 1);
        set.put('V', 5);
        set.put('X', 10);
        set.put('L', 50);
        set.put('C', 100);
        set.put('D', 500);
        set.put('M', 1000);
        int last = set.get(romans[0]);
        int current;
        for (int i = 1; i < romans.length; i++) {
            current = set.get(romans[i]);
            if (last < current) {
                result -= last;
            }
            else {
                result += last;
            }
            last = current;
        }
        result += last;
        return result;
    }

    public static void main(String[] args) {
        RomanToInt rti = new RomanToInt();
        String roman = args[0];
        int result = rti.romanToInt(roman);
        System.out.println(roman + " to Int = " + result);

    }

}

public class LengthOfSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] letters = new int[127];
        char[] str = s.toCharArray();
        int max = 0;
        int length = 0;
        int i = 0;
        int p = 0;
        while (i < str.length) {
            while (p < str.length && letters[getIndex(str[p])] == 0) {
                length++;
                letters[getIndex(str[p])] = 1;
                p++;
            }
            if (length > max) {
                max = length;
            }
            if (p < str.length) {
                letters[getIndex(str[p])] = 0;
                while (str[i] != str[p]) {
                    letters[getIndex(str[i])] = 0;
                    i++;
                    length--;
                }
                i++;
                length--;
            }
            else {
                break;
            }
        }
        return max;
    }
    private int getIndex(char character) {
        int index = (int) character;
        return index;
    }
    public static void main(String[] args) {
        LengthOfSubstring los = new LengthOfSubstring();
//        String s = "abcdefdhibcl";
        String s = "tmmzuxt";
        int ret = los.lengthOfLongestSubstring(s);
        System.out.println("ret = " + ret);

    }

}

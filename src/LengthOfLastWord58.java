/**
 * Created by Amysue on 2016/8/28.
 */
public class LengthOfLastWord58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWord58 ll = new LengthOfLastWord58();
        String s = "     d length     ";
        int length = ll.lengthOfLastWord(s);
        System.out.println("length = " + length);
    }
}

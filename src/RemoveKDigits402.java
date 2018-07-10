/**
 * @author :  ZouShumin
 * @Project Name :  Leetcode
 * @Package Name :  PACKAGE_NAME
 * @Description :
 * @Creation Date:  2018-07-10 13:38
 * --------  ---------  --------------------------
 */
public class RemoveKDigits402 {
    public String removeKdigits(String num, int k) {
        if (k == 0) {
            return num;
        }
        if (k == num.length()) {
            return "0";
        }

        int[] nums = new int[num.length()];
        for(int i = 0; i < num.length(); i++) {
            nums[i] = num.charAt(i) - '0';
        }
        int start = 0;
        int originK = k;

        while (start < nums.length && k > 0) {
            if ((start + k) == nums.length) {
                removeDigits(nums, start, k);
                break;
            }
            int i = start;
            int min = nums[start];
            int found = start;
            while (i < nums.length && i <= start + k) {
                if (nums[i] == 0) {
                    found = i;
                    break;
                }
                if (nums[i] < min) {
                    found = i;
                    min = nums[i];
                }
                i++;
            }
            int kLen = found - start;
            k = k - kLen;
            removeDigits(nums, start, kLen);
            start = found + 1;
        }

        start = 0;
        while (start < nums.length && nums[start] < 1) {
            if (nums[start] == -1) {
                originK--;
            }
            start++;
        }
        int resultLen = nums.length - start - originK;
        if (resultLen > 0 && start < nums.length) {
            char[] resultChars = new char[resultLen];
            int i = 0;
            while (start < num.length()) {
                if (nums[start] != -1) {
                    resultChars[i++] = (char) (nums[start] + '0');
                }
                start++;
            }
            return new String(resultChars);
        } else {
            return "0";
        }
    }

    private void removeDigits(int[] nums, int start, int len) {
        for(int j = 0; j < len; j++) {
            nums[start + j] = -1;
        }
    }

    public static void main(String[] args) {
        RemoveKDigits402 rk = new RemoveKDigits402();
//        String num = "1432219"; int k = 3;
//        String num = "10200"; int k = 1;
//        String num = "10"; int k = 2;
        String num = "1000219"; int k = 4;
        System.out.println(rk.removeKdigits(num, k));
    }
}

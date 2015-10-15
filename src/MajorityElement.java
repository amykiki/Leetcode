import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int capacity = (nums.length+ 1)/2;
        HashMap<Integer, Integer> count = new HashMap<>(capacity);
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            int value = 1;
            if (count.containsKey(key)) {
                value = count.get(key) + 1;
            }
            count.put(key, value);
            if (value >= capacity) {
                majority = key;
                break;
            }
        }
        return majority;
    }
    
    public static void main (String[] args) {
        int[] nums = {3, 1, 2, 3};
        MajorityElement me = new MajorityElement();
        int majority = me.majorityElement(nums);
        System.out.println("majority is " + majority);
    }
}

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            if (majority != value) {
                count--;
            }
            else {
                count++;
            }
            if (count == 0) {
                majority = value;
                count++;
            }
        }
        return majority;
    }
    
    public static void main (String[] args) {
        int[] nums = {3, 2, 2, 4, 3, 9, 3};
        MajorityElement me = new MajorityElement();
        int majority = me.majorityElement(nums);
        System.out.println("majority is " + majority);
    }
}

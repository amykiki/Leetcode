import java.util.LinkedList;

/**
 * Created by Amysue on 2016/8/17.
 */
public class JumpGame45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        LinkedList<Integer> nodes = new LinkedList<>();
        nodes.add(0);
        boolean[] marked = new boolean[nums.length];
        marked[0] = true;
        int N = nums.length - 1;
        int level = 0;
        while (!nodes.isEmpty()) {
            int count = nodes.size();
            while (count > 0) {
                int j = nodes.removeFirst();
                for(int i = nums[j]; i > 0; i--) {
                    if (j + i >= N) {
                        return ++level;
                    }
                    if (!marked[j + i]) {
                        marked[j+i] = true;
                        nodes.add(j+i);
                    }
                }
                count--;
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        JumpGame45 jg = new JumpGame45();
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3, 4, 3, 2, 5, 4, 3};
        int result = jg.jump(nums);
        System.out.println("result = " + result);
    }

}

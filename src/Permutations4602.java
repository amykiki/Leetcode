import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amysue on 2016/8/18.
 */
public class Permutations4602 {
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
        results.add(new ArrayList<>(Arrays.asList(nums[0])));
        for(int i = 1; i < nums.length; i++) {
            addNum(nums[i]);
        }
        return results;
    }

    public void addNum(int num) {
        int Len = results.size();
        for (int j = 0; j < Len; j++) {
            List<Integer> list = results.get(j);
            for(int i = 0; i < list.size(); i++) {
                List<Integer> list1 = new ArrayList<>(list);
                list1.add(i, num);
                results.add(list1);
            }
            list.add(num);
        }
    }

    public static void main(String[] args) {
        Permutations4602 pt2 = new Permutations4602();
        int[] nums = {1, 2, 3};
        List<List<Integer>> results = pt2.permute(nums);
        System.out.println(results.size());
        System.out.println(results);
    }
}

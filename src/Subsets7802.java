import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amysue on 2016/9/29.
 */
public class Subsets7802 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        int resultsSize = 1;
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < resultsSize; j++) {
                List<Integer> list = new ArrayList<>(results.get(j));
                list.add(nums[i]);
                results.add(list);
            }
            resultsSize *= 2;
        }
        return results;
    }

    public static void main(String[] args) {
        Subsets7802 ss = new Subsets7802();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        List<List<Integer>> results = ss.subsets(nums);
        System.out.println(results.size());
        System.out.println(results);
    }
}

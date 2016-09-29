import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amysue on 2016/9/29.
 */
public class Subsets78 {
    int LEN = 0;

    public List<List<Integer>> subsets(int[] nums) {
        LEN = nums.length - 1;
        List<List<Integer>> results = new ArrayList<>();
        List<List<Integer>> lasts   = new ArrayList<>();
        results.add(new ArrayList<>());
        results.add(new ArrayList<>(Arrays.asList(nums[LEN])));
        for(int i = 0; i < LEN; i++) {
            lasts.add(new ArrayList<>(Arrays.asList(nums[i])));
        }
        results.addAll(lasts);
        addSubsets(lasts, results, nums);
        return results;
    }

    private void addSubsets(List<List<Integer>> lasts, List<List<Integer>> results, int[] nums) {
        if (lasts.size() > 0) {
            List<List<Integer>> nexts   = new ArrayList<>();
            List<Integer>       list1;
            for (int i = 0; i < lasts.size(); i++) {
                List<Integer> crtList = lasts.get(i);
                list1 = new ArrayList<>(crtList);
                list1.add(nums[LEN]);
                results.add(list1);
                int end = crtList.get(crtList.size() - 1);
                for (int j = LEN-1; j >= 0; j--) {
                    if(nums[j] == end) break;
                    List<Integer> list2 = new ArrayList<>(crtList);
                    list2.add(nums[j]);
                    nexts.add(list2);
                }
            }
            results.addAll(nexts);
            addSubsets(nexts, results, nums);
        }
    }

    public static void main(String[] args) {
        Subsets78 ss = new Subsets78();
//        int[]               nums    = {4, 2, 1, 3};
//        int[]               nums    = {9, 0, 3, 5, 7};
        int[]               nums    = {1, 2, 3, 4, 5, 6, 7};
        List<List<Integer>> results = ss.subsets(nums);
        System.out.println(results);
        System.out.println(results.size());
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Amysue on 2016/8/13.
 */
public class CombinationSum40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> last = new LinkedList<>();
        combine(candidates, target, result, last, 0);
        return result;
    }

    private void combine(int[] candidates, int target, List<List<Integer>> result, LinkedList<Integer> last, int start) {
        int lastI = -1;
        for(int i = start; i < candidates.length; i++) {
            int n = candidates[i];
            if (n == lastI) {
                continue;
            }
            if (n == target) {
                addList(result, last, target);
                return;
            }
            if (n > target) {
                return;
            }
            if (n * 2 > target) {
                /*if (Arrays.binarySearch(candidates, i + 1, candidates.length, target) >= 0) {
                    addList(result, last, target);
                }
                return;*/
                continue;
            }
            last.add(n);
            combine(candidates, target - n, result, last, i + 1);
            last.removeLast();
            lastI = n;
        }
    }
    private void addList(List<List<Integer>> results, LinkedList<Integer> lasts, Integer... nums) {
        List<Integer> li = new ArrayList<>(lasts);
        li.addAll(Arrays.asList(nums));
        results.add(li);
    }

    public static void main(String[] args) {
        CombinationSum40 cs = new CombinationSum40();
        int[] candidates = {2, 3, 5, 6, 1, 3, 4, 2, 1, 7, 8, 9};
        int target = 9;
        List<List<Integer>> results = cs.combinationSum2(candidates, target);
        System.out.println(results.size());
        System.out.println(results);
    }
}

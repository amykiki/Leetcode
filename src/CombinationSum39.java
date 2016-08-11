import java.util.*;

/**
 * Created by Amysue on 2016/8/11.
 */
public class CombinationSum39 {
    private Map<Integer, List<List<Integer>>> map = new HashMap<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<Integer>        sets   = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            sets.add(candidates[i]);
        }
        return combine(sets, target, candidates);
    }

    private List<List<Integer>> combine(Set<Integer> sets, int target, int[] candidates) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        LinkedList<List<Integer>> coms = new LinkedList<>();
        int last = -1;
        for (int i = 0; i < candidates.length; i++) {
            int m = candidates[i];
            if (m * 2 > target) {
                break;
            }
            if (m == last) {
                continue;
            }
            List<List<Integer>> l2 = combine(sets, target - m, candidates);
            if (l2 != null) {
                for (List<Integer> list : l2) {
                    if (m > list.get(0)) {
                        break;
                    }
                    List<Integer> ll = new ArrayList<>();
                    ll.add(m);
                    ll.addAll(list);
                    coms.push(ll);
                }
            }
            last = m;
        }
        if (sets.contains(target)) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(target);
            coms.push(l1);
        }
        if (coms.isEmpty()) {
            map.put(target, null);
            return coms;
        } else {
            map.put(target, coms);
            return coms;
        }
    }

    public static void main(String[] args) {
        CombinationSum39 cs = new CombinationSum39();
//        int[] candiates = {2, 3, 4, 5, 6, 7, 9};
//        int[]               candiates = {7, 1, 2, 3, 9, 5, 6, 7, 8, 4};
//        int                 target    = 9;
        int[]               candiates = {3, 7};
        int                 target    = 7;
//        int[] candiates = {2};
//        int target = 1;
        List<List<Integer>> result    = cs.combinationSum(candiates, target);
        System.out.println(result.size());
        System.out.println(result);
        /*List<List<Integer>> l = new ArrayList<>();
        l.add(new LinkedList<>());
        for (List<Integer> i : l) {
            System.out.println(i.get(0));
            System.out.println(i);
        }*/

    }
}

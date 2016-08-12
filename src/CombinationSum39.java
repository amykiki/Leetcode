import java.util.*;

/**
 * Created by Amysue on 2016/8/11.
 */
public class CombinationSum39 {
    private Map<Integer, List<List<Integer>>> map = new HashMap<>();

    /*public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
    }*/
    /*public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int                 n  = candidates[0];
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(Arrays.asList(n));
        map.put(n, ls);
        return combine(target, candidates);
    }
    private List<List<Integer>> combine(int target, int[] candidates) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        LinkedList<List<Integer>> coms = new LinkedList<>();
        int                       last = -1;
        for (int i = 0; i < candidates.length; i++) {
            int m = candidates[i];
            if (m == last) {
                continue;
            }
            if (m * 2 > target) {
                break;
            } else if (m * 2 == target) {
                List<Integer> ll = new ArrayList<>();
                ll.add(m);
                ll.add(m);
                coms.push(ll);
                break;
            }
            List<List<Integer>> l2 = combine(target - m, candidates);
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
        if (Arrays.binarySearch(candidates, target) >= 0) {
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
    }*/

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> last    = new LinkedList<>();

        add(candidates, target, 0, results, last);
        System.out.println(results.size());
        System.out.println(results);
        return results;
    }

    private void add(int[] candidates, int target, int start, List<List<Integer>> results, LinkedList<Integer> lasts) {
        int lastI = -1;
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] == lastI) {
                continue;
            }
            lastI = candidates[i];
            if (lastI == target) {
                addList(results, lasts, lastI);
                return;
            }
            if (lastI > target) {
                return;
            }
            if (lastI * 2 > target) {
                if (Arrays.binarySearch(candidates, target) >= 0) {
                    addList(results, lasts, target);
                }
                return;
            }

            lasts.add(lastI);
            add(candidates, target - lastI, i, results, lasts);
            lasts.removeLast();
        }
    }

    private void addList(List<List<Integer>> results, LinkedList<Integer> lasts, Integer... nums) {
        List<Integer> li = new ArrayList<>(lasts);
        li.addAll(Arrays.asList(nums));
        results.add(li);
    }

    public static void main(String[] args) {
        CombinationSum39 cs = new CombinationSum39();
//        int[]            candiates = {2, 3, 4, 5, 6, 9};
        int[] candiates = {7, 1, 2, 3, 9, 5, 6, 7, 8, 4};
        int   target    = 9;
//        int[]               candiates = {2,3,4,7};
//        int                 target    = 7;
//        int[] candiates = {2};
//        int target = 1;
        /*List<List<Integer>> result = cs.combinationSum(candiates, target);
        System.out.println(result.size());
        System.out.println(result);*/
        cs.combinationSum(candiates, target);
        /*List<List<Integer>> l = new ArrayList<>();
        l.add(new LinkedList<>());
        for (List<Integer> i : l) {
            System.out.println(i.get(0));
            System.out.println(i);
        }*/

    }
}

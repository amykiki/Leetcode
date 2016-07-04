import java.util.*;

/**
 * Created by Amysue on 2016/7/2.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(new Integer(i));
        }
        return permuteList(list);
    }
// 深度优先算法
    private List<List<Integer>> permuteList(List<Integer> pList) {
        List<List<Integer>> result = new ArrayList<>();
        if (pList.size() == 1) {
            result.add(pList);
        } else {
            if (pList.size() == 2) {
                if (pList.get(0) == pList.get(1)) {
                   result.add(pList);
                    return result;
                }
            }
            Set<Integer> heads = new HashSet<>();
            for (int i = 0; i < pList.size(); i++) {
                Integer num = pList.get(i);
                if (!heads.contains(num)) {
                    heads.add(pList.get(i));
                    List<Integer> nextList = new ArrayList<>(pList);
                    nextList.remove(i);
                    List<List<Integer>> cLists = permuteList(new ArrayList<>(nextList));
                    for (List<Integer> list : cLists) {
                        list.add(0, num);
                        result.add(list);
                    }
                }

            }
        }

        return result;

    }

    private Set<List<Integer>> permuteSub(int[] nums, int head) {
        Set<List<Integer>> result = new HashSet<>();
        if (head == nums.length - 1) {
            result.add(new ArrayList<Integer>(Arrays.asList(nums[head])));
        } else {
            Set<List<Integer>> lastList = permuteSub(nums, head + 1);
            int                current  = nums[head];
            for (List<Integer> list : lastList) {
                boolean sameNum = false;
                int i = 0;
                while (i <= list.size()) {
                    if (!sameNum) {
                        List<Integer> permuteList = new ArrayList<>(list);
                        permuteList.add(i, current);
                        result.add(permuteList);
                        if (i < list.size() && current == list.get(i)) {
                            sameNum = true;
                        }
                    } else {
                        if (i < list.size() && list.get(i) != current) {
                            sameNum = false;
                        }
                    }
                    i++;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 1};
//        int[] nums = {2,  2, 1, 1};
        int[] nums = {1, 1, 1, 2};
//        int[] nums = {1, 2, 3};
        PermutationsII      permutationsII = new PermutationsII();
        List<List<Integer>> result         = permutationsII.permuteUnique(nums);
        System.out.println(result);
//        System.out.println(sets);
    }
}

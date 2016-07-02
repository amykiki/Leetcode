import java.util.*;

/**
 * Created by Amysue on 2016/7/2.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        return new ArrayList<>(permuteSub(nums, 0));
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
        int[] nums = {2,  2, 1, 1};
//        int[] nums = {1, 2, 3};
        PermutationsII      permutationsII = new PermutationsII();
        List<List<Integer>> result         = permutationsII.permuteUnique(nums);
        Set<List<Integer>>  sets           = new HashSet<>(result);
        System.out.println(result);
//        System.out.println(sets);
    }
}

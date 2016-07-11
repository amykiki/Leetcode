import java.util.*;

/**
 * Created by Amysue on 2016/7/10.
 */
public class FourSum018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 4) {
            return results;
        }
        Map<Integer, Integer> nMap = new HashMap<>();
//        Map<Integer, Set<ThreeSum>> threeMap = new HashMap<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int iValue = nums[i];
            if (nMap.containsKey(iValue)) {
                nMap.put(iValue, nMap.get(iValue) + 1);
                continue;
            } else {
                nMap.put(iValue, 1);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int iValue = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int jValue = nums[j];
                for (int k = j + 1; k <nums.length; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    int key = iValue + jValue + nums[k];
                    int diff = target - key;

                    if (diff > iValue || diff < nums[0]) {
                        continue;
                    }
                    if (nMap.containsKey(diff)) {
                        int m = nMap.get(diff);
                        int count = 0;
                        Integer[] data = {iValue, jValue, nums[k]};
                        for (int n : data) {
                            if (n == diff) {
                                count++;
                            } else {
                                break;
                            }
                        }
                        if (count + 1 > m) {
                            continue;
                        }
                        List<Integer> sum = new ArrayList<>(Arrays.asList(data));
                        sum.add(0, diff);
                        results.add(sum);
                    }
                    /*ThreeSum threeSum = new ThreeSum(iValue, jValue, nums[k]);
                    if (threeMap.containsKey(key)) {
                        threeMap.get(key).add(threeSum);
                    } else {
                        Set<ThreeSum> set = new HashSet<>();
                        set.add(threeSum);
                        threeMap.put(key, set);
                    }*/

                }
            }
        }
        /*for(int i = 0; i < nums.length; i++) {
            int iValue = nums[i];
            if (nMap.containsKey(iValue)) {
                nMap.put(iValue, nMap.get(iValue) + 1);
                continue;
            } else {
                nMap.put(iValue, 1);
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int jValue = nums[j];
                for (int k = j + 1; k <nums.length; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    int key = iValue + jValue + nums[k];
                    int diff = target - key;
                    if (diff > iValue || diff < nums[0]) {
                        continue;
                    }
                    ThreeSum threeSum = new ThreeSum(iValue, jValue, nums[k]);
                    if (threeMap.containsKey(key)) {
                        threeMap.get(key).add(threeSum);
                    } else {
                        Set<ThreeSum> set = new HashSet<>();
                        set.add(threeSum);
                        threeMap.put(key, set);
                    }

                }
            }
        }
//        System.out.println(threeMap);
//        System.out.println(nMap);
        List<Integer> sNums = new ArrayList<>(nMap.keySet());
        Collections.sort(sNums);
//        System.out.println(sNums);
        for (int i : sNums) {
            int key = target - i;
            if (threeMap.containsKey(key)) {
                Set<ThreeSum> threes = threeMap.get(key);
                for (ThreeSum t : threes) {
                    if (t.getData()[0] < i) {
                        continue;
                    }
                    int count = 0;
                    for (int n : t.getData()) {
                        if (n == i) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count + 1 > nMap.get(i)) {
                        continue;
                    }
                    List<Integer> sum = new ArrayList<>(Arrays.asList(t.getData()));
                    sum.add(0, i);
                    results.add(sum);
                }
            }
        }*/
        return results;
    }

    private static class ThreeSum {
        private Integer[] data;
        public Map<Integer, Integer> map = new HashMap<>(3);

        public ThreeSum(int i, int j, int k) {
            data = new Integer[]{i, j, k};

        }
        public ThreeSum() {

        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ThreeSum other = new ThreeSum();
            if (this.getClass() == obj.getClass()) {
                other = (ThreeSum) obj;
            }
            for (int i = 0; i < data.length; i++) {
                if (!data[i].equals(other.data[i])) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(data);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (int i = 0; i < data.length; i++) {
                sb.append(data[i]);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            return sb.toString();
        }

        public Integer[] getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        FourSum018 fs   = new FourSum018();
//        int[] nums = {1, 0, -1, 0, 0, 0, -2, 2};
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int[] nums = {1, 1, 1, 1, 0, 0, 0, 0};
//        int[] nums = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
//        int target = 0;
        /*int[] nums = {-493,-482,-482,-456,-427,-405,-392,-385,-351,-269,-259,-251,-235,-235,-202,-201,-194,-189,-187,-186,-180,-177,-175,-156,-150,-147,-140,-122,-112,-112,-105,-98,-49,-38,-35,-34,-18,20,52,53,57,76,124,126,128,132,142,147,157,180,207,227,274,296,311,334,336,337,339,349,354,363,372,378,383,413,431,471,474,481,492};
        int target = 6189;*/
        /*int[] nums = {-493,-470,-464,-453,-451,-446,-445,-407,-406,-393,-328,-312,-307,-303,-259,-253,-252,-243,-221,-193,-126,-126,-122,-117,-106,-105,-101,-71,-20,-12,3,4,20,20,54,84,98,111,148,149,152,171,175,176,211,218,227,331,352,389,410,420,448,485};
        int target = 1057;*/
       /* int[] nums = {-477,-476,-471,-462,-440,-400,-398,-394,-394,-393,-389,-386,-350,-346,-338,-315,-273,-249,-182,-172,-166,-161,-149,-116,-112,-109,-100,-73,-33,-26,-22,-11,6,8,13,19,56,78,101,102,111,140,155,158,181,205,211,225,232,242,254,265,281,308,310,320,320,364,366,381,385,387,443,496,496};
        int target = 1236;*/
        int[] nums = {91277418,66271374,38763793,4092006,11415077,60468277,1122637,72398035,-62267800,22082642,60359529,-16540633,92671879,-64462734,-55855043,-40899846,88007957,-57387813,-49552230,-96789394,18318594,-3246760,-44346548,-21370279,42493875,25185969,83216261,-70078020,-53687927,-76072023,-65863359,-61708176,-29175835,85675811,-80575807,-92211746,44755622,-23368379,23619674,-749263,-40707953,-68966953,72694581,-52328726,-78618474,40958224,-2921736,-55902268,-74278762,63342010,29076029,58781716,56045007,-67966567,-79405127,-45778231,-47167435,1586413,-58822903,-51277270,87348634,-86955956,-47418266,74884315,-36952674,-29067969,-98812826,-44893101,-22516153,-34522513,34091871,-79583480,47562301,6154068,87601405,-48859327,-2183204,17736781,31189878,-23814871,-35880166,39204002,93248899,-42067196,-49473145,-75235452,-61923200,64824322,-88505198,20903451,-80926102,56089387,-58094433,37743524,-71480010,-14975982,19473982,47085913,-90793462,-33520678,70775566,-76347995,-16091435,94700640,17183454,85735982,90399615,-86251609,-68167910,-95327478,90586275,-99524469,16999817,27815883,-88279865,53092631,75125438,44270568,-23129316,-846252,-59608044,90938699,80923976,3534451,6218186,41256179,-9165388,-11897463,92423776,-38991231,-6082654,92275443,74040861,77457712,-80549965,-42515693,69918944,-95198414,15677446,-52451179,-50111167,-23732840,39520751,-90474508,-27860023,65164540,26582346,-20183515,99018741,-2826130,-28461563,-24759460,-83828963,-1739800,71207113,26434787,52931083,-33111208,38314304,-29429107,-5567826,-5149750,9582750,85289753,75490866,-93202942,-85974081,7365682,-42953023,21825824,68329208,-87994788,3460985,18744871,-49724457,-12982362,-47800372,39958829,-95981751,-71017359,-18397211,27941418,-34699076,74174334,96928957,44328607,49293516,-39034828,5945763,-47046163,10986423,63478877,30677010,-21202664,-86235407,3164123,8956697,-9003909,-18929014,-73824245};
        int target = -236727523;
        List<List<Integer>> result = fs.fourSum(nums, target);
        System.out.println(result);
        System.out.println(result.size());
    }
}

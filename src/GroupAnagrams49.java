import java.util.*;

/**
 * Created by Amysue on 2016/8/19.
 */
public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> data = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String sn = new String(s);
            if (data.containsKey(sn)) {
                data.get(sn).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                data.put(sn, list);
            }
        }
        List<List<String>> results = new ArrayList<>();
        for (String s : data.keySet()) {
            results.add(data.get(s));
        }
        return results;
    }

    public static void main(String[] args) {
        GroupAnagrams49 ga = new GroupAnagrams49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> results = ga.groupAnagrams(strs);
        System.out.println(results);
    }
}

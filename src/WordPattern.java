import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    
    public boolean wordPattern(String pattern, String str) {
        int[] data = new int[pattern.length()];
        String[] strs = str.split(" ");
        if (strs.length != data.length) return false;
        
        HashMap<Character, Integer> map = new HashMap<>(pattern.length());
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            if (map.containsKey(key)) {
                data[i] = map.get(key);
            }
            else {
                map.put(key, i);
                data[i] = i;
            }
        }
        Boolean result = true;
        HashSet<String> set = new HashSet<>(map.size());
        for (int i = 0; i < data.length && result; i++) {
            String key = strs[i];
            if (i == data[i]) {
                if (set.contains(key)) {
                    result = false;
                }
                else {
                    set.add(key);
                }
            }
            else {
                if (!key.equals(strs[data[i]])) result = false;
            }
       
        }
        return result;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WordPattern wp = new WordPattern();
        boolean result = wp.wordPattern("aaa", "dog dog dog dog");
        if (result) {
            System.out.println("match");
        }
        else {
            System.out.println("Not match");
        }
    }

}

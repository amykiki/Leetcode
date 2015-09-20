import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakTwo {
    private String str;
    private String[] allIndex;
    private String[] result;
    private String[] dicts;
    private ArrayList<String> wordsList = new ArrayList<>();
    private int num = 0;
    public ArrayList<String> wordBreak(String s, Set<String> wordDict) {
        str = s;
        result = new String[s.length()];
        Arrays.fill(result, "-1");
        allIndex = new String[s.length()];
        Arrays.fill(allIndex, "-1");
        dicts = wordDict.toArray(new String[wordDict.size()]);
        System.out.println(s);
        System.out.println(Arrays.toString(dicts));
        
        for (int i = 0; i < dicts.length; i++) {
            int index = s.indexOf(dicts[i]);
            while (index >= 0) {
                for (int j = index; j < index + dicts[i].length(); j++) {
                    allIndex[j] = "1";
                }
                if (result[index].equals("-1")) {
                    result[index] = Integer.toString(i);
                }
                else {
                    result[index] = result[index] + ":" + Integer.toString(i);
                }
                index = s.indexOf(dicts[i], index + 1);
            }
            
        }
        for (int i = 0; i < allIndex.length; i++) {
            if (allIndex[i].equals("-1")) {
                System.out.println("The Str Can Not be break as the Set");
                return wordsList;
            }
        }
        String breakPass = wordBreak(0);
        if (! breakPass.equals("0")) {
            System.out.println("The Str Can be break as the Set");
            System.out.println("The size of the list is " + wordsList.size());
            System.out.println("list[0] is " + wordsList.get(0));
            if (!wordsList.isEmpty()) {
                System.out.print(wordsList.toString() + " ");
            }
        }
        else {
            System.out.println("The Str Can Not be break as the Set");
        }
        return wordsList;
    }
    
    private String wordBreak (int index) {
        if (index == str.length()) {
            num++;
            return Integer.toString(num);
        }
        
        int[] nList = toIntList(result[index]);
        if (nList[0] == -1) {
            return "0";
        }
        String rct = "0";
        for (int i = 0; i < nList.length; i++) {
            int j = nList[i];
            String word = dicts[j];
//            System.out.println("index = " + i + ", word = " + word);
            int nextIndex = index + word.length();
            String rc = wordBreak(nextIndex);
            if (!rc.equals("0")) {
                int listLen = wordsList.size();
                if (listLen < num) {
                    wordsList.add(word);
                }
                else {
                    int[] indexes = toIntList(rc);
                    for (int k : indexes) {
                        k--;
                        String beforeWord = wordsList.get(k);
                        wordsList.set(k, word + " " + beforeWord);
                    }
                }
                if (rct.equals("0")) {
                    rct = rc;
                }
                else {
                    rct = rct + ":" + rc;
                }
            }
        }
        return rct;
    }
    private int[] toIntList(String s) {
        String[] sList = s.split(":", 0);
        int[] nList = new int[sList.length];
        for (int i = 0; i < sList.length; i++) {
            nList[i] = Integer.parseInt(sList[i]);
        }
        return nList;
    }
    public static void main (String[] args) {
        WordBreakTwo wb = new WordBreakTwo();
//        String str = "abcdefabcdefgh";
//        Set<String> dict = new HashSet<String>(Arrays.asList("fgh", "abc", "abcdef", "de"));
//        String str = "bb";
//        Set<String> dict = new HashSet<String>(Arrays.asList("a","b","bbb","bbbb"));
        String str = "aaaaaaa";
        Set<String> dict = new HashSet<String>(Arrays.asList("aaaa", "aa", "a"));
//        String str = "catsanddog";
//        Set<String> dict = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        wb.wordBreak(str, dict);
    }
}

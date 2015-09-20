import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordBreak {
    private String str;
    private String[] allIndex;
    private String[] result;
    private String[] dicts;
    private LinkedList<String> words = new LinkedList<>();
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        str = s;
        result = new String[s.length()];
        Arrays.fill(result, "-1");
        allIndex = new String[s.length()];
        Arrays.fill(allIndex, "-1");
        dicts = wordDict.toArray(new String[wordDict.size()]);
        System.out.println(s);
        System.out.println(Arrays.toString(dicts));
//        LinkedList<String> dictList = new LinkedList<>(wordDict);
        
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
                return false;
            }
        }
        boolean breakPass = wordBreak(0);
        if (breakPass) {
            System.out.println("The Str Can be break as the Set");
            while (!words.isEmpty()) {
                System.out.print(words.pollLast() + " ");
            }
            return true;
        }
        System.out.println("The Str Can Not be break as the Set");
        return false;
    }
    
//    private boolean wordBreak (int index, LinkedList<String> list) {
//        if (index == str.length()) {
//            return true;
//        }
//        
//        int[] nList = toIntList(result[index]);
//        if (nList[0] == -1) {
//            return false;
//        }
//        for (int i = 0; i < nList.length; i++) {
//            int j = nList[i];
//           String word = list.get(j);
//           if (word.equals("-1")) {
//               continue;
//           }
//           list.set(j, "-1");
//            int nextIndex = index + word.length();
//            boolean rc = wordBreak(nextIndex, list);
//            if (rc) {
//                words.add(word);
//                return true;
//            }
//            list.set(j, word);
//        }
//        return false;
//    }
    private boolean wordBreak (int index) {
        if (index == str.length()) {
            return true;
        }
        
        int[] nList = toIntList(result[index]);
        if (nList[0] == -1) {
            return false;
        }
        for (int i = 0; i < nList.length; i++) {
            int j = nList[i];
           String word = dicts[j];
            int nextIndex = index + word.length();
            boolean rc = wordBreak(nextIndex);
            if (rc) {
                words.add(word);
                return true;
            }
        }
        return false;
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
        WordBreak wb = new WordBreak();
//        String str = "abcdefabcdefgh";
//        Set<String> dict = new HashSet<String>(Arrays.asList("fgh", "abc", "abcdef", "de"));
        String str = "bb";
        Set<String> dict = new HashSet<String>(Arrays.asList("a","b","bbb","bbbb"));
//        String str = "mmmmmm";
//        Set<String> dict = new HashSet<String>(Arrays.asList("mmmm", "mm"));
        wb.wordBreak(str, dict);
    }
}

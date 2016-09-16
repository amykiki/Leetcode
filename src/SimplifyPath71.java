import java.util.LinkedList;

/**
 * Created by Amysue on 2016/9/16.
 */
public class SimplifyPath71 {
    public String simplifyPath(String path) {
        if (path == null || !path.startsWith("/")) {
            return null;
        }
        String[] simplified = new String[path.length() / 2];
        int index = -1;
        int start = -1;
        for (int i = 1; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                if (start != -1) {
                    String s = path.substring(start, i);
                    index = handle(simplified, index, s);
                    start = -1;
                }
            } else {
                if (start == -1) {
                    start = i;
                }
            }
        }
        if (start != -1) {
            String s = path.substring(start, path.length());
            index = handle(simplified, index, s);
        }
        if (index == -1) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i <= index; i++) {
                sb.append(simplified[i]);
            }
            return sb.toString();
        }
    }

    private int handle(String[] simplified, int index, String s) {
        if (!s.equals(".")) {
            if (s.equals("..")) {
                if (index >= 0) {
                    index--;
                }
            } else {
                s = "/" + s;
                simplified[++index] = s;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        SimplifyPath71 sf = new SimplifyPath71();
//        String path = "/a/./b/../../c/";
//        String path = "/home/";
//        String path = "/../";
        String path = "/...";
//        String path = "///home////foo//////../";
        String simplified = sf.simplifyPath(path);
        System.out.println("simplified = " + simplified);
    }

}

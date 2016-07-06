import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Amysue on 2016/7/6.
 */
public class Pascal118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>(numRows);
        if (numRows >= 1) {
            results.add(Arrays.asList(1));
        }
        if (numRows >= 2) {
            results.add(Arrays.asList(1, 1));
        }
        if (numRows < 3) {
            return results;
        }
        /*
        * 注意在中间的迭代部分，用数组Array代替list比较快。
        * 我一开始用ArrayList但是速度没有直接用数组快*/
        for (int i = 3; i <= numRows; i++) {
            Integer[] row = new Integer[i];
            row[0] = 1;
            List<Integer> lastList = results.get(i - 2);
            int middle = (i - 1)/2;
            int j;
            for (j = 1; j <= middle; j++) {
                row[j] = lastList.get(j - 1) + lastList.get(j);
            }
            for (j = middle + 1; j < i; j++) {
                row[j] = row[i - j - 1];
            }
            results.add(Arrays.asList(row));
        }
        return results;
    }

    public static void main(String[] args) {
        Pascal118 pascal118 = new Pascal118();
        List<List<Integer>> result = pascal118.generate(6);
        System.out.println(result);
    }
}

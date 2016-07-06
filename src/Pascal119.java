import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amysue on 2016/7/6.
 */
public class Pascal119 {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        Integer[] row = new Integer[rowIndex];
        if (rowIndex == 1) {
            row[0] = 1;
        } else if (rowIndex >= 2) {
            row[0] = 1;
            row[1] = 1;
        }
        if (rowIndex < 3) {
            return Arrays.asList(row);
        }

        for (int i = 3; i <= rowIndex; i++) {
            int middle = (i - 1) / 2;
            int j;
            for (j = 1; j <= middle; j++) {
                int last = i - j - 1;
                if (last > middle) {
                    row[j] = row[i - j - 1] + row[j];
                } else {
                    row[j] = 2 * row[j];
                }
            }
            for (j = middle + 1; j < i; j++) {
                row[j] = row[i - j - 1];
            }
        }
        return Arrays.asList(row);
    }

    public static void main(String[] args) {
        Pascal119     pascal119 = new Pascal119();
        List<Integer> result    = pascal119.getRow(6);
        System.out.println(result);
    }

}

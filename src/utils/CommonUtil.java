package utils;

/**
 * Created by zoushumin on 2017/9/4.
 */
public class CommonUtil {
    public static String arrayToStr(int[] array) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void printArray(int[] array) {
        System.out.println(arrayToStr(array));
    }
}

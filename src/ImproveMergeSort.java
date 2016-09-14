import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Amysue on 2016/9/12.
 */
public class ImproveMergeSort {
    public int[] sort(int[] a) {
        int[] aux = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }
        sort(a, aux, 0, a.length - 1);
        return aux;
    }


    private void sort(int[] a, int[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        int middle = low + (high - low)/2;
        sort(aux, a, low, middle);
        sort(aux, a, middle+1, high);
        merge(a, aux, low, middle, high);
    }
    private void merge(int[] a, int[] aux, int low, int middle, int high) {
        int i = low;
        int j = middle + 1;
        for(int k = low; k <= high; k++) {
            if(i > middle) aux[k] = a[j++];
            else if(j > high) aux[k] = a[i++];
            else if(a[j] < a[i]) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
    }


    public static void main(String[] args) {
        Random rand = new Random();
//        int[] a = new int[20];
        int[] a = new int[10];
        Set<Integer> datas = new HashSet<>();
        int i = 0;
        while (i < a.length) {
            int num = rand.nextInt(30);
            if (datas.contains(num)) {
                continue;
            }
            a[i] = num;
            datas.add(num);
            i++;
        }
//        int[] a = {25, 27, 18, 4, 15, 23, 22, 16, 13, 28};
//        int[] a = {25, 27, 18, 15,4};
        System.out.println(Arrays.toString(a));
        ImproveMergeSort im = new ImproveMergeSort();
        a = im.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

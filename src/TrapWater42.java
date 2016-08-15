import java.util.LinkedList;

/**
 * Created by Amysue on 2016/8/14.
 */
public class TrapWater42 {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int left = height[0];
        int leftJ = 0;
        int sum = 0;
        LinkedList<Integer> hs = new LinkedList<>();
        int rangeSum = 0;
        for(int i = 1; i < height.length; i++) {
            if (left > height[i]) {
                rangeSum += height[i];
                hs.push(height[i]);
            } else {
                int range = i - leftJ - 1;
                if (range >= 1) {
                    sum += range * left - rangeSum;
                }
                left = height[i];
                leftJ = i;
                rangeSum = 0;
                hs.clear();
            }
        }
        if (!hs.isEmpty()) {
            int right = hs.pop();
            while (!hs.isEmpty()) {
                int h = hs.pop();
                if (h < right) {
                    sum += right - h;
                } else {
                    right = h;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TrapWater42 tw = new TrapWater42();
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] heights = {2,0,2};
        int water = tw.trap(heights);
        System.out.println("water = " + water);
    }
}

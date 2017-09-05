import java.util.Random;

/**
 * Created by zoushumin on 2017/9/3.
 */
public class BestTimeToBuyStock123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] firstHalf = {0, 0};
        int[] secondHalf = {0,0};
        int lastSellPoint = -1;
        int secondHalfStart = 0;
        int count = 0;
        int oneTimeSellPoint = 0;
        int firstHalfStart = 0;
        int firstHalfProfit = 0;
        int secondHalfProfit = 0;
        int maxProfit = 0;
//        int[] result = new int[4];
        while (true) {
            secondHalf = findMaxProfit(secondHalfStart, lastSellPoint, prices);
            firstHalf = findNextMaxProfit(firstHalfStart, secondHalf[0] - 1, firstHalf[0], firstHalf[1], prices);
            secondHalfStart = secondHalf[0] + 1;
            lastSellPoint = secondHalf[1];
            if (firstHalf[0] != 0) {
                firstHalfStart = firstHalf[1] + 1;
            }
            if (count == 0) {
                oneTimeSellPoint = secondHalf[1];
            }
            firstHalfProfit = prices[firstHalf[1]] - prices[firstHalf[0]];
            secondHalfProfit = prices[secondHalf[1]] - prices[secondHalf[0]];
            if ((firstHalfProfit + secondHalfProfit) > maxProfit) {
                maxProfit = firstHalfProfit + secondHalfProfit;
                /*result[0] = firstHalf[0];
                result[1] = firstHalf[1];
                result[2] = secondHalf[0];
                result[3] = secondHalf[1];*/
            }
            if (secondHalfStart > oneTimeSellPoint) {
                break;
            }
            count++;
        }
       /* System.out.println(CommonUtil.printArray(result));
        System.out.println("firstHalfProfit = " + (prices[result[1]] - prices[result[0]]));
        System.out.println("secondHalfProfit = " + (prices[result[3]] - prices[result[2]]));*/
        return maxProfit;
    }

    private int[] findMaxProfit(int start,  int lastSellPoint, int[] prices){
        //0: buyPoint, 1: sellPoint, 2: maxProfit
        int[] results = new int[2];
        int maxProfit = 0;
        int buyPoint = -1;
        int sellPoint = -1;
        if (lastSellPoint > 0) {
            int lastSellPrice = prices[lastSellPoint];
            for(int i = start; i < lastSellPoint; i++) {
                if ((lastSellPrice - prices[i]) >= maxProfit) {
                    maxProfit = lastSellPoint - prices[i];
                    buyPoint = i;
                }
            }
        }

        //获取在已找到的卖点后面的最大的买卖点
        int nextSTart = lastSellPoint +1;
        if(nextSTart < prices.length){
            int[] nextResults = findNextMaxProfit(nextSTart, prices.length - 1, nextSTart, nextSTart, prices);
            int nextBuyPoint = nextResults[0];
            int nextSellPoint = nextResults[1];
            int nextMaxProfit = prices[nextSellPoint] - prices[nextBuyPoint];
            if (nextMaxProfit >= maxProfit) {
                buyPoint = nextBuyPoint;
                sellPoint = nextSellPoint;
            }
        }
        if (buyPoint == -1) {
            buyPoint = lastSellPoint;
            sellPoint = lastSellPoint;
        }

        results[0] = buyPoint;
        results[1] = sellPoint;
        return results;
    }

    /**
     * 查找给定范围的最大利润值，注意start和end是加在已查找的范围后面的
     * 已查找出的买卖点由currentBuyPoint和currentSellPoint给出
     * 因为新加的范围是连续跟在已查找出的区域的后面的，因此只需要比较新加的价格能够产生的最大利润就可以了
     * 并且currentBuyPoint必定是
     * @param start 新加的查找范围起点
     * @param end 新加的查找范围的终点
     * @param currentBuyPoint 当前已查找出的最佳买点
     * @param currentySellPoint 当前已查找出的最佳卖点
     * @param prices
     * @return
     */
    private int[] findNextMaxProfit(int start, int end, int currentBuyPoint, int currentySellPoint, int[] prices) {
        int minPoint = currentBuyPoint;
        int maxProfit = prices[currentySellPoint] - prices[currentBuyPoint];
        if (end >= start) {
            for(int i = start; i <= end; i++) {
                if (prices[i] < prices[minPoint]) {
                    minPoint = i;
                }else {
                    int profit = prices[i] - prices[minPoint];
                    if (profit > maxProfit) {
                        maxProfit = profit;
                        currentySellPoint = i;
                        currentBuyPoint = minPoint;
                    }
                }
            }
        }


        int[] results = new int[2];
        results[0] = currentBuyPoint;
        results[1] = currentySellPoint;
        return results;

    }

    public static void main(String[] args) {
        BestTimeToBuyStock123 bttb = new BestTimeToBuyStock123();
        int arrayLength = 20;
        /*int[] prices = new int[arrayLength];
        Random random = new Random();
        for(int i = 0; i < arrayLength; i++) {
            prices[i] = random.nextInt(50);
        }*/
//        int[] prices = {18, 6, 40, 0, 47, 0, 23, 15, 1, 22, 39, 19, 39, 17, 27, 14, 26, 14, 47, 26};
//        int[] prices = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] prices = {10, 10, 10, 10, 10, 10, 10, 10};
//        int[] prices = {1, 2};
        int[] prices = {1, 2, 4};
        System.out.println("prices = " + CommonUtil.printArray(prices));

        int maxProfit = bttb.maxProfit(prices);
        System.out.println("maxProfit = " + maxProfit);
    }

}

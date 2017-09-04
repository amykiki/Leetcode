import java.util.Random;

/**
 * Created by zoushumin on 2017/9/3.
 */
public class BestTimeToBuyStock123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }
        //1 找到一次买卖点的最大值
        int[] oneTimeMaxProfit = findNextMaxProfit(0, prices.length - 1, 0, 0, prices);
        //如果一次最大的买卖点都没找到，就返回0
        if (oneTimeMaxProfit[0] == oneTimeMaxProfit[1]) {
            return 0;
        }
        System.out.println("oneTimeMaxProfit = " + CommonUtil.printArray(oneTimeMaxProfit));
        System.out.println("BuyPointPrice = " + prices[oneTimeMaxProfit[0]] + ", SellPointPrice = " + prices[oneTimeMaxProfit[1]]);

        int start = oneTimeMaxProfit[0];


        return prices[oneTimeMaxProfit[1]] - prices[oneTimeMaxProfit[0]];
    }

    private int[] findMaxProfit(int start, int lastSellPoint, int[] prices){
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
        int[] nextResults = findNextMaxProfit(nextSTart, prices.length - 1, nextSTart, nextSTart, prices);
        int nextBuyPoint = nextResults[0];
        int nextSellPoint = nextResults[1];
        int nextMaxProfit = prices[nextSellPoint] - prices[nextBuyPoint];
        if (nextMaxProfit >= maxProfit) {
            buyPoint = nextBuyPoint;
            sellPoint = nextSellPoint;
        }
        results[0] = buyPoint;
        results[1] = sellPoint;
        return results;
    }

    private int[] findNextMaxProfit(int start, int end, int currentBuyPoint, int currentySellPoint, int[] prices) {
        int minPoint = currentBuyPoint;
        int maxProfit = prices[currentySellPoint] - prices[currentBuyPoint];
        for(int i = start; i <= end; i++) {
            if (prices[i] <= minPoint) {
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
        int[] prices = {18, 6, 40, 0, 47, 0, 23, 15, 1, 22, 39, 19, 39, 17, 27, 14, 26, 14, 47, 26};
        System.out.println("prices = " + CommonUtil.printArray(prices));

        int maxProfit = bttb.maxProfit(prices);
        System.out.println("maxProfit = " + maxProfit);
    }

}

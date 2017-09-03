/**
 * Created by zoushumin on 2017/9/3.
 */
public class BestTimeToBuyStock123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }
        return 0;
    }

    public int[] findMaxProfit(int start, int lastSellPoint, int[] prices){
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

        int newMaxProfit = -1;
        int newBuyPoint = lastSellPoint + 1;
        int newSellPoint = -1;
        for(int j = newBuyPoint + 1; j <prices.length; j++) {
            if (prices[j] <= newBuyPoint) {
                newBuyPoint = j;
            }else {
                if ((prices[j] - prices[newBuyPoint]) > newMaxProfit) {
                    newMaxProfit = prices[j] - prices[newBuyPoint];
                    newSellPoint = j;
                }
            }
        }
        if (newMaxProfit >= maxProfit) {
            buyPoint = newBuyPoint;
            sellPoint = newSellPoint;
        }
        results[0] = buyPoint;
        results[1] = sellPoint;
        return results;
    }

}

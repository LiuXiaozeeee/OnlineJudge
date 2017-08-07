/**
 * Created by Liuxz on 2017/7/30.
 */
public class Leet309BestTimetoBuyandSellStockWithCooldown {

    public static void main(String[] args){
        Leet309BestTimetoBuyandSellStockWithCooldown  xx = new Leet309BestTimetoBuyandSellStockWithCooldown();
        System.out.println(xx.maxProfit(new int[]{1,2,0,3,5,7,9,3,2,1,4,2}));
        System.out.println(xx.maxProfit(new int[]{}));
        System.out.println(xx.maxProfit(new int[]{1}));
        System.out.println(xx.maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(xx.maxProfit(new int[]{2,1,4}));
    }

    public int maxProfit(int[] prices){
        if (prices.length<2){return 0;}
        if (prices.length == 2){return Math.max(0,prices[1]-prices[0]);}
        int[] result = new int[prices.length];
        result[0] = 0;
        result[1] = Math.max(prices[1]-prices[0],0);
//        result[2] = Math.max(result[1], prices[2] - prices[0]);
        for(int i = 2; i < prices.length; i ++){
            result[i] = Math.max(result[i], result[i-1]);
            for (int k = 0; k <= i-1;k ++){
                if (k< 3){
                    result[i] = Math.max(result[i], prices[i]-prices[k]);
                }
                if ((k >= 1)&&(k < i-1)){
                    result[i] = Math.max(result[k]+ prices[i]-prices[k+2],
                            result[i]);
                }
            }
        }
        return result[result.length-1];
    }
}

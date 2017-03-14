/**
 * Created by liuxz on 17-3-12.
 */
public class Leet121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int lmin=Integer.MAX_VALUE;
        int max=0;
        for (int price : prices) {
            if (price < lmin) {
                lmin = price;
            }
            if (max < price - lmin) {
                max = price - lmin;
            }
        }
        return max;
    }

    public static void main(String[] args){
        Leet121BestTimetoBuyandSellStock xx = new Leet121BestTimetoBuyandSellStock();
        System.out.println(xx.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}

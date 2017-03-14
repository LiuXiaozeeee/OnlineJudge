/**
 * Created by liuxz on 17-3-12.
 */
public class Leet123BestTimetoBuyandSelStockIII {
    public int maxProfit(int[] prices) {
        int[] r = new int[prices.length];
        int[] l = new int[prices.length];
        int min=Integer.MAX_VALUE;
        int stay = -1;
        for (int i = 0 ; i < prices.length ; i ++){
            min = min<prices[i]?min:prices[i];
            r[i] = (prices[i]-min)<stay?stay:(prices[i]-min);
            stay = r[i];
        }
        int max = 0;
        stay= -1;
        for (int i = prices.length-1; i >=0; i --){
            max = max<prices[i]?prices[i]:max;
            l[i]= (max - prices[i])<stay?stay:(max-prices[i]);
            stay = l[i];
        }
        int sum = 0 ;
        for (int i = 0 ; i < prices.length; i ++){
            sum = sum>(r[i]+l[i])?sum:(r[i]+l[i]);
        }
        return sum;
    }

    public static void main(String[] args){
        Leet123BestTimetoBuyandSelStockIII xx = new Leet123BestTimetoBuyandSelStockIII();
        System.out.println(xx.maxProfit(new int[]{6,1,6,4,3,0,2}));
    }
}

/**
 * Created by liuxz on 17-4-7.
 */
public class Leet188BestTimetoBuyandSellStockIV {
    public static void main(String[] args){
        Leet188BestTimetoBuyandSellStockIV xx = new Leet188BestTimetoBuyandSellStockIV();
        System.out.println(xx.maxProfit(3, new int[]{2,3,5,7,1,3}));
    }

    public int maxProfit(int k, int[ ] prices){
        if ((prices.length == 0)||(k == 0)){
            return 0;
        }
        int l = prices.length;
        int[][] matrix = new int[k+1][l];
	int[] vec = new int[l];
	
        for (int kk = 0; kk <= k; kk ++){
            for (int i = 0 ; i < l; i ++){
                if ((kk == 0)||(i == 0)){
                    matrix[kk][i]=0;
                }else{
                    int temp = 0;
                    for (int j = 0; j < i; j ++){
                        temp = Math.max(temp, matrix[kk-1][j] + (prices[i]-prices[j]));
                    }
                    matrix[kk][i] = Math.max(temp, matrix[kk][i-1]);
                }
            }
        }
        return matrix[k][l-1];
    }
}

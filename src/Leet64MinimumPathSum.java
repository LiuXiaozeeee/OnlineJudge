/**
 * Created by liuxz on 17-3-5.
 */
public class Leet64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m ; i ++){
            for (int j = 0 ; j < n ; j ++){
                if ((i == 0)&&(j == 0)){
                    matrix[i][j]=grid[i][j];
                }else if(i == 0){
                    matrix[i][j] = matrix[i][j-1] + grid[i][j];
                }else if (j == 0){
                    matrix[i][j] = matrix[i-1][j] + grid[i][j];
                }else{
                    matrix[i][j] = matrix[i-1][j] < matrix[i][j-1]?
                            matrix[i-1][j]:matrix[i][j-1];
                    matrix[i][j] +=grid[i][j];
                }
            }
        }
        return matrix[m-1][n-1];
    }

    public static void main(String[] args){
        Leet64MinimumPathSum xx = new Leet64MinimumPathSum();
        System.out.println(xx.minPathSum(new int[][]{
                new int[]{1,2},
                new int[]{3,4}
        }));
    }

}

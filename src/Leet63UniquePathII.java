/**
 * Created by liuxz on 17-3-5.
 */
public class Leet63UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] matrix = new int[m][n];
        matrix[0][0]=1 - obstacleGrid[0][0];
        for (int i = 1 ; i< m ; i++){
            if (obstacleGrid[i][0] == 1) {
                matrix[i][0]=0;
            }else{
                matrix[i][0] = matrix[i-1][0];
            }
        }

        for (int j = 1 ; j< n ; j++){
            if (obstacleGrid[0][j] == 1) {
                matrix[0][j]=0;
            }else{
                matrix[0][j] = matrix[0][j-1];
            }
        }

        for (int i = 1 ; i < m ; i++){
            for (int j = 1 ; j < n; j ++){
                matrix[i][j] = matrix[i-1][j]+matrix[i][j-1];
                if (obstacleGrid[i][j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args){
        Leet63UniquePathII xx = new Leet63UniquePathII();
        System.out.println(xx.uniquePathsWithObstacles(new int[][]{new int[]{0,0,0},
                new int[]{0,1,0}, new int[]{0,0,0}}));
        System.out.println(xx.uniquePathsWithObstacles(new int[][]{
                new int[]{1,0}
        }));
    }

}

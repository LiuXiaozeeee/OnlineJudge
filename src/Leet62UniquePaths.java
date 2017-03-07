/**
 * Created by liuxz on 17-3-5.
 */
public class Leet62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int j = 0 ; j < n ; j ++) matrix[0][j]=1;
        for (int i = 0 ; i < m ; i ++) matrix[i][0]=1;
        for (int j = 1 ; j < n ; j ++){
            for (int i = 1; i < m; i ++){
                matrix[i][j] = matrix[i-1][j]+matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }

    public static void main(String[] args){
        Leet62UniquePaths xx = new Leet62UniquePaths();
        System.out.println(xx.uniquePaths(3,7));
    }
}

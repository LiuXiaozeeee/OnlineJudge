/**
 * Created by liuxz on 17-4-7.
 */
public class Leet174DungeonGame {
    public static void main(String[] args){
        Leet174DungeonGame xx = new Leet174DungeonGame();
        System.out.println(xx.calculateMinimumHP(new int[][]{
            new int[]{-2,-3,3},
            new int[]{-5,-10,1},
            new int[]{10,30,-5}
        }));
    }

    public int calculateMinimumHP(int[][] dungeon){
        int m = dungeon.length, n = dungeon[0].length;
        int [][] matrix = new int[m][n];
        for (int i = m-1; i >= 0; i --){
            for(int j = n-1; j >= 0; j --){
                if ((i == m-1)&&(j == n-1)){
                    matrix[i][j] = Math.max(1, 1-dungeon[i][j]);
                }else if (i == m - 1){
                    matrix[i][j] = Math.max(1, matrix[i][j+1]-dungeon[i][j]);
                }else if (j == n - 1){
                    matrix[i][j] = Math.max(1, matrix[i+1][j]-dungeon[i][j]);
                }else{
                    matrix[i][j] = Math.max(1, Math.min(matrix[i+1][j], matrix[i][j+1])-dungeon[i][j]);
                }
            }
        }
        return matrix[0][0];
    }
}

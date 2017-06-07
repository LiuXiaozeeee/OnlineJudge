/**
 * Created by Liuxz on 2017/6/7.
 */
public class Leet304RangeSumQuery2DImmutable {
    int [][] cumsum;
    public Leet304RangeSumQuery2DImmutable(int[][] matrix) {
        int n = matrix.length;
        if(n == 0){return;}
        int m = matrix[0].length;
        if (m == 0){return ;}
        cumsum = new int[n][m];
        for (int i = 0; i < n ; i ++){
            for (int j = 0; j < m; j ++){
                if (j ==0){cumsum[i][j] = matrix[i][j];}
                else{
                    cumsum[i][j] = cumsum[i][j-1]+matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int  sum = 0;
        for (int r = row1; r<=row2; r++){
            if(col1 == 0){sum+= cumsum[r][col2];}
            else{
                sum+=cumsum[r][col2]-cumsum[r][col1-1];
            }
        }
        return sum;
    }

    public static void main(String[] args){
//        Leet304RangeSumQuery2DImmutable xx = new Leet304RangeSumQuery2DImmutable(new int[][]{
//                new int[]{3, 0, 1, 4, 2},
//                new int[]{5, 6, 3, 2, 1},
//                new int[]{1, 2, 0, 1, 5},
//                new int[]{4, 1, 0, 1, 7},
//                new int[]{1, 0, 3, 0, 5}
//        });

        Leet304RangeSumQuery2DImmutable xx = new Leet304RangeSumQuery2DImmutable(new int[][]{
                new int[]{1},
                new int[]{-7},
        });
        System.out.println(xx.sumRegion(0,0,0,0));
        System.out.println(xx.sumRegion(1,0,1,0));
        System.out.println(xx.sumRegion(0,0,1,0));

    }
}

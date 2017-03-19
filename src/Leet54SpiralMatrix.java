import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by liuxz on 17-3-19.
 */

public class Leet54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        if (n == 0){
            return res;
        }
        int m = matrix[0].length;
        int left =0;
        int right = m-1;
        int up = 0;
        int down = n-1;
        while(true){
            for(int i = left ; i <= right ; i ++){
                    res.add(matrix[up][i]);
            }
            if (res.size() == m*n){break;}
            up ++;
            for (int i = up; i <= down ; i ++){
                res.add(matrix[i][right]);
            }
            if (res.size() == m*n){break;}
            right --;
            for (int i = right; i >= left; i --){
                res.add(matrix[down][i]);
            }
            if (res.size() == m*n){break;}
            down -- ;
            for (int i = down; i >= up ; i --){
                res.add(matrix[i][left]);
            }
            if (res.size() == m*n){break;}
            left ++;
        }
        return res;
    }

    public static void main(String[] args){
        Leet54SpiralMatrix xx = new Leet54SpiralMatrix();
        int[][] input = new int[][]{
//                new int[]{1,2,3},
//                new int[]{4,5,6},
//                new int[]{7,8,9},
//                new int[]{10,11,12}
        };
        System.out.println(xx.spiralOrder(input));
    }


}

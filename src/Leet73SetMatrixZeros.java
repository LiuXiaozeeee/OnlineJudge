import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liuxz on 17-3-21.
 */
public class Leet73SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
        int l = matrix.length;
        int w = matrix[0].length;
        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        for (int i = 0; i < l; i ++){
            for (int j = 0 ; j < w; j ++){
                if (matrix[i][j] == 0){
                    a.add(i);
                    b.add(j);
                }
            }
        }
        for (int i : a){
            for (int j = 0; j < w; j ++){
                matrix[i][j] = 0;
            }
        }
        for(int j:b){
            for (int i = 0 ; i < l; i ++){
                matrix[i][j] = 0;
            }
        }
    }


    public static void main(String[] args){
        Leet73SetMatrixZeros xx = new Leet73SetMatrixZeros();
        int[][] matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,0,6},
                new int[]{7,8,9},
                new int[]{7,8,9},
        };
        xx.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

}

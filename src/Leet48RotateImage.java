import java.util.Arrays;

/**
 * Created by liuxz on 17-2-7.
 */
public class Leet48RotateImage {
    public void rotate(int[][] matrix) {
        int l = matrix.length-1;
        for (int i = 0 ; i < (matrix.length+1)/2; i ++){
            for (int j = i ; j < l-i;j ++){
                roll(matrix, i,j, j,l-i,l-i, l-j,l-j,i);
            }
        }
    }
    public static void main(String[] args){
        Leet48RotateImage xx = new Leet48RotateImage();
        int [][] pic = new int[][]{
                new int[]{1,2,3,4},
                new int[]{5,6,7,8},
                new int[]{9,10,11,12},
                new int[]{13,14,15,16}
        };
        xx.rotate(pic);
        System.out.println(Arrays.deepToString(pic));
    }

    private void roll(int[][] matrix, int upleft1, int upleft2,
                      int upright1, int upright2,
                      int downright1, int downright2,
                      int downleft1, int downleft2){
        int temp = matrix[upleft1][upleft2];
        matrix[upleft1][upleft2]=matrix[downleft1][downleft2];
        matrix[downleft1][downleft2] = matrix[downright1][downright2];
        matrix[downright1][downright2]=matrix[upright1][upright2];
        matrix[upright1][upright2] = temp;
    }
}

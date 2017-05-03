/**
 * Created by liuxz on 17-5-3.
 */
public class Leet74Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if ((matrix.length == 0)|| matrix[0].length  == 0){
            return false;
        }

        int[] rowHead = new int[matrix.length];
        for (int i = 0 ; i < matrix.length; i ++){
            rowHead[i] = matrix[i][0];
        }
        int row = binarySearch(rowHead, 0, rowHead.length-1, target );
        int col = binarySearch(matrix[row], 0, matrix[row].length-1, target);
        System.out.println(String.format("%d,%d",row,col));
        return matrix[row][col] == target;
    }

    public static void main(String[] args){
        Leet74Searcha2DMatrix xx = new Leet74Searcha2DMatrix();
        System.out.println(xx.searchMatrix(new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50}
        }, 15));
        System.out.println(xx.searchMatrix(new int[][]{
                new int[]{1}
        }, 0));
        System.out.println(xx.searchMatrix(new int[][]{
                new int[]{1,3,5,7},
                new int[]{10,11,16,20},
                new int[]{23,30,34,50}
        }, 30));
    }

    int binarySearch(int[] vec, int start, int end, int target){
        if ((start == end -1 )|| (start == end)){
            if (vec[end] <= target){return end;}
            else {return start;}
        }
        int mid = (start + end)/2;
        if (vec[mid] == target){return mid;}
        if (vec[mid] < target){return binarySearch(vec, mid, end, target);}
        else {return binarySearch(vec, start, mid, target);}
    }

}

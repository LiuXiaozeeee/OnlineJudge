import java.util.*;

/**
 * Created by liuxz on 17-3-12.
 */
public class Leet132PalindromePartitioningII {


    public int minCut(String s) {
        int l;
        boolean [][] matrix;
        l = s.length();
        matrix = new boolean[l][l];
        int[] vec = new int[l];
        for (int i = 0 ; i < l; i++){
            matrix[i][i]=true;
            vec[i]=i;
        }
        for (int i = 1; i < l ; i ++){
            for (int j = i; j >=0 ; --j){
                if ((s.charAt(i) == s.charAt(j)) &&((i-j<2)||matrix[i-1][j+1])){
                    if (j == 0){
                        vec[i]=0;
                    }else{
                        matrix[i][j]=true;
                        vec[i]=Math.min(vec[j-1]+1,vec[i]);
                    }
                }
            }
        }
        return vec[l-1];
    }

    public static void main(String[] args){
        Leet132PalindromePartitioningII xx = new Leet132PalindromePartitioningII();
        System.out.println(xx.minCut("aab"));
    }
}

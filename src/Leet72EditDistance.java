import java.util.Arrays;

/**
 * Created by liuxz on 17-3-5.
 */
public class Leet72EditDistance {
    public int minDistance(String word1, String word2) {
        word1 = "`"+word1+"~";
        word2 = "`"+word2+"~";
        int m = word1.length();
        int n = word2.length();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m;i ++){
            matrix[i][0] = i;
        }
        for (int j = 0; j < n; j ++){
            matrix[0][j] = j;
        }

        for (int i = 1 ; i < m ; i ++){
            for (int j = 1 ; j < n ; j ++){
                matrix[i][j]=min(matrix[i-1][j]+1,matrix[i][j-1]+1,matrix[i-1][j-1]+
                        (word1.charAt(i) == word2.charAt(j) ? 0:1));
            }
        }

//        System.out.print("~\t");
//        for (int j = 0 ; j < n ; j ++)
//            System.out.print(word2.charAt(j)+"\t");
//        System.out.println();
//        for (int i = 0; i < m; i ++){
//            System.out.print(word1.charAt(i)+"\t");
//            for (int j = 0; j < n; j ++){
//                System.out.print(matrix[i][j] + "\t");
//            }
//            System.out.println();
//        }

        return matrix[m-1][n-1];
    }

    private static int min(int a, int b,int c){
        int temp = a<b?a:b;
        return temp<c?temp:c;
    }

    public static void main(String[] args){
        Leet72EditDistance xx = new Leet72EditDistance();
//        System.out.println(xx.minDistance("",""));
//        System.out.println(xx.minDistance("a","ab"));
//        System.out.println(xx.minDistance("zoologicoarchaeologist"
//        ,"zoogeologist"));
        System.out.println(xx.minDistance("zoog","zoolog"));
    }
}

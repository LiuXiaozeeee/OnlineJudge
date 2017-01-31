/**
 * Created by Liuxz on 2017/1/31.
 */
public class Leet44WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] matrix = new boolean[m+1][n+1];
        matrix[0][0]=true;
        if(!p.isEmpty() &&p.charAt(0) == '*'){
            for (int i = 0 ; i < p.length();  i ++) {
                if (p.charAt(i) == '*') {
                    matrix[0][i+1] = true;
                }else{
                    break;
                }
            }
        }

        for (int i = 0 ; i < m; i ++){
            for (int j = 0 ; j < n ; j ++){
                if (s.charAt(i) == p.charAt(j)|| p.charAt(j)=='?'){
                    matrix[i+1][j+1] = matrix[i][j];
                }
                else if (p.charAt(j) == '*'){
                    matrix[i+1][j+1] = false;
                    for (int t = i; t>=-1 ; t--){
                        if (matrix[t+1][j]){
                            matrix[i+1][j+1]=true;
                            break;
                        }
                    }
                }
            }
        }
        return matrix[m][n];
    }

    public static void main(String[] args){
        Leet44WildcardMatching xx = new Leet44WildcardMatching();
        System.out.println(xx.isMatch("ho","**ho"));
    }
}

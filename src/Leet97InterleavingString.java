import com.sun.org.apache.bcel.internal.classfile.InnerClass;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by liuxz on 17-3-10.
 */
public class Leet97InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length() + s2.length())!=s3.length()){
            return false;
        }
        s1 = '`'+s1;s2 = '`'+s2;s3='`'+s3;
        boolean [][] matrix = new boolean[s1.length()][s2.length()];
        matrix[0][0] = true;
        for (int i = 1 ; i < s1.length();i ++){
            matrix[i][0]= matrix[i-1][0]&&(s1.charAt(i)==s3.charAt(i));
        }
        for (int j = 1 ; j < s2.length(); j ++){
            matrix[0][j] =matrix[0][j-1]&&(s2.charAt(j)==s3.charAt(j));
        }

        for(int i = 1 ; i < s1.length(); i++){
            for (int j = 1 ; j < s2.length(); j++){
                matrix[i][j] = (matrix[i-1][j] && (s1.charAt(i) == s3.charAt(i+j))) ||
                        (matrix[i][j-1] && (s2.charAt(j) == s3.charAt(i+j)));
            }
        }
        return matrix[s1.length()-1][s2.length()-1];
    }

    private void pr(boolean[][] matrix){
        for (int i = 0 ; i < matrix.length; i ++){
            for( int j = 0; j < matrix[i].length ; j++){
                System.out.print(matrix[i][j] +"\t");
            }
            System.out.println("\n");
        }
    }

    private boolean isInterleave3(String s1, String s2, String s3) {
        if ((s1.length() + s2.length())!=s3.length()){
            return false;
        }
        s1 = '`'+s1;s2 = '`'+s2;s3='`'+s3;

        rec x = new rec(s1,s2,s3);
        return x.getValue(s1.length()-1, s2.length()-1)>0;
    }

    private class rec {
        int[][] matrix;
        String s1;String s2;String s3;
        rec(String s1, String s2, String s3){
            matrix = new int[s1.length()][s2.length()];
            this.s1=s1;this.s2=s2;this.s3=s3;
        }
        public void setValue(int i , int j ,int value){
            matrix[i][j] = value;
        }

        public int getValue(int i, int j){
            if(matrix[i][j] == 0){
                if ((i == 0)&&(j == 0)){
                    matrix[i][j]=1;
                }else if(i == 0){
                    if ((s2.charAt(j) == s3.charAt(j)) &&(getValue(i,j-1)==1)){
                        matrix[i][j] = 1;
                    }else{
                        matrix[i][j] = -1;
                    }
                }else if (j == 0){
                    if ((s1.charAt(i) == s3.charAt(i))&&(getValue(i-1,j) == 1)){
                        matrix[i][j]=1;
                    }else{
                        matrix[i][j]=-1;
                    }
                }else{
                    if (((s1.charAt(i)==s3.charAt(i+j))&&(getValue(i-1,j) == 1))||
                    ((s2.charAt(j)==s3.charAt(i+j))&&(getValue(i,j-1) == 1))){
                        matrix[i][j] = 1;
                    }else{
                        matrix[i][j] = -1;
                    }
                }
            }
            return matrix[i][j];
        }
    }



    public static void main(String[] args){
        Leet97InterleavingString xx = new Leet97InterleavingString();
//        System.out.println(xx.isInterleave3("aabcc","dbbca","aadbbcbcac"));
//        System.out.println(xx.isInterleave("aabcc","dbbca","aadbbbaccc"));
        System.out.println(xx.isInterleave3("abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb",
                "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc",
                "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc"));
    }
}

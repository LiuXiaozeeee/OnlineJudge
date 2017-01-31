import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Liuxz on 2017/1/30.
 */
public class Leet43MultiplyStrings {
    public String multiply(String num1, String num2) {
        if ((Objects.equals(num1,"0"))||(Objects.equals(num2,"0"))){
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m+n+2];
        for (int i = 0; i<m; i ++){
            for (int j = 0; j < n; j ++){
                int temp = (num1.charAt(m-i-1)-'0')*(num2.charAt(n-j-1)-'0');
                temp += result[i+j];
                result[i+j]=temp%10;
                result[i+j+1]+=temp/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i;
        for (i = result.length-1 ; i >=0 ; i --){
            if(result[i] != 0){
                break;
            }
        }
        for(; i >= 0; i --){

            sb.append(result[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args){
        Leet43MultiplyStrings xx = new Leet43MultiplyStrings();
        System.out.println(xx.multiply("0","9"));
    }

}

import java.util.Objects;

/**
 * Created by Liuxz on 2017/6/28.
 */
public class Leet151ReverseWordsinaString {
    public static void main(String[] args){
        Leet151ReverseWordsinaString xx = new Leet151ReverseWordsinaString();
        System.out.println(xx.reverseWords(" the sky    is blue "));
    }

    public String reverseWords(String s) {
        String[] x = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = x.length-1; i >=1; i --){
            if(!Objects.equals(x[i].trim(),"")){
                result.append(x[i].trim());
                result.append(" ");
            }
        }
        result.append(x[0].trim());
//        s = result.toString();
        return result.toString();

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by liuxz on 17-5-3.
 */
public class Leet67AddBinary {
//    public String addBinary(String a, String b) {
//        Integer[] x = (Integer[]) Arrays.asList(new StringBuilder(a).reverse().toString().toCharArray()).stream().map((chars) -> {
//            return Integer.parseInt(new String(chars));}
//        ).toArray();
//
//        char[] y = b.toCharArray();
//        List<Integer> result = new ArrayList<>();
//        int index = 0;
//        return "";
//    }

    public String addBinary(String a, String b){
        StringBuilder aa = new StringBuilder(a).reverse();
        StringBuilder bb = new StringBuilder(b).reverse();
        StringBuilder result = new StringBuilder();

        int index = 0;
        int flag = 0;
        while(true){
            char atA;
            char atB;
            if ((index >= aa.length())&&(index >= bb.length())){
                if (flag == 1){
                    result.append('1');
                }
                return result.reverse().toString();
            }
            if (index < aa.length()){
                atA = aa.charAt(index);
            }else{atA = '0';}

            if (index < bb.length()){
                atB = bb.charAt(index);
            }else{atB = '0';}

            int sum = atA - '0' + atB -'0' + flag;
            result.append((char)('0' +  sum%2));
            flag = sum/2;
            index++;
        }
    }

    public static void main(String[] args){
        Leet67AddBinary xx = new Leet67AddBinary();
        System.out.println(xx.addBinary("1111","11"));
    }
}

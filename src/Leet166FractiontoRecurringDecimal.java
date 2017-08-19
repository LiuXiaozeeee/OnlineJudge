import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * Created by Liuxz on 2017/8/18.
 */
public class Leet166FractiontoRecurringDecimal {
    HashMap<Long, Integer> r = new HashMap<>();

    public static void main(String[] args){
        Leet166FractiontoRecurringDecimal xx = new Leet166FractiontoRecurringDecimal();
        System.out.println(xx.checkSign(1,2));
        System.out.println(
                xx.fractionToDecimal(1,2)
        ); // 0.5
        System.out.println(
                xx.fractionToDecimal(2,1)
        ); // 2
        System.out.println(
                xx.fractionToDecimal(2, 3)
        ); // 0.(6)
        System.out.println(
                xx.fractionToDecimal(97, 17)
        ); // 5.705882353
        System.out.println(
                xx.fractionToDecimal(-50,8)
        );
        System.out.println(
                xx.fractionToDecimal(-50,8)
        );
        System.out.println(
                xx.fractionToDecimal(-1,
                -2147483648)
        );
        System.out.println(
                xx.fractionToDecimal(-2147483648
                        ,1)
        );
    }

    public String fractionToDecimal(int numerator_x, int denominator_x) {
        long denominator = (long) denominator_x;
        long numerator = (long) numerator_x;
        String sign = checkSign(numerator, denominator);
//        String sign = "";
        r.clear();
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        long a = numerator/denominator;
        long b = numerator%denominator;
        StringBuffer result_a = new StringBuffer();
        StringBuffer result_b = new StringBuffer();
        if (b == 0){return sign + Long.toString(a);}
        result_a.append(Long.toString(a));
        result_a.append(".");
        int cur = 0;
        r.put(b,cur);

        while(true){
            long[] temp = div(b*10, denominator);
            result_b.append(temp[0]);
            b = temp[1];
            if (b == 0){
                return sign+result_a.toString() + result_b.toString();
            }
            if (r.containsKey(b)){
                result_b.insert(r.get(b), "(");
                result_b.append(')');
                return sign+result_a.toString()+result_b.toString();
            }else {
                r.put(b, cur+1);
                cur = cur +1;
            }
        }
    }

    private String checkSign(long numerator, long denominator){
        if ((((double)numerator)/denominator) >= 0){
            return "";
        }else{
            return "-";
        }
    }

    private long[] div (long numerator, long denominator){
        long[] result = new long[2];
        result[0] = numerator/denominator;
        result[1] = numerator%denominator;
        return result;
    }

//    private String prepareOutput(StringBuilder res, int i, int a){
//        return Integer.toString(a) + '.' + res.subSequence(0,res.length()-2*i).toString() + '('
//                + res.subSequence(res.length()-2*i, res.length()-i) + ')';
//    }
//
//    private String prepareOutput(StringBuilder res, int a){
//        return Integer.toString(a)+'.'+res.toString();
//    }

//    private boolean checkPalin(StringBuilder a, int index){
//        int l =a.length();
//        if (l < 2){
//            return false;
//        }
//        if (Objects.equals(a.subSequence(l-2*index, l-index) ,a.subSequence(l-index,l))){
//            return true;
//        }else{
//            return false;
//        }
//    }
}

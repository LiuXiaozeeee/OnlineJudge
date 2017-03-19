import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuxz on 17-3-19.
 */
public class Leet65ValidNumber {
    //TLE
    public boolean isNumber(String s){
        s = s.trim();
        return s.matches("[-+]?(([0-9]+(\\.[0-9]*)?)|\\.[0-9]+)(e[-+]?[0-9]+)?");
    }

    public static void main(String[] args){
        Leet65ValidNumber xx = new Leet65ValidNumber();
//        System.out.println(xx.isNumber("2e0"));
//        System.out.println(xx.isNumber("8..e4"));
        System.out.println(xx.isNumber(".2e81"));
        System.out.println(xx.isNumber("96 e5"));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liuxz on 17-3-19.
 */
public class Leet93RestoreIPAddresses {
    public List<String> result = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if ((s.length() >= 13)||(s.length()<=3)){
            return result;
        }
        List<String> res = new ArrayList<>();
        deepin(s, res);
        return  result;
    }

    void deepin(String s, List<String> res){
        if ((s.length() == 0)&&(res.size() == 4)){
            result.add(String.join(".",res));
            return;
        }
        if (res.size()<3){
            for (int i = 1 ; i <= Math.min(3,s.length()); i ++){
                String x = s.substring(0,i);
                if (valid(x)){
                    res.add(x);
                    deepin(s.substring(i,s.length()),res);
                    res.remove(res.size() - 1);
                }
            }
        }else if(res.size() == 3){
            if ((s.length()!=0)&&(valid(s))){
                res.add(s);
                deepin("",res);
                res.remove(2);
            }
        }
    }

    boolean valid(String x){
        if(x.length()>=4){
            return false;
        }
        if (x.startsWith("0")&&x.length()!=1){
            return false;
        }
        int t = Integer.parseInt(x);
        if ((0<=t)&&(t<=255)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        Leet93RestoreIPAddresses xx = new Leet93RestoreIPAddresses();
        System.out.println(xx.restoreIpAddresses("010010"));
    }

}

import java.util.*;

/**
 * Created by Liuxz on 2017/7/25.
 */
public class Leet187RepeatedDNASequences {
    public static void main(String[] args){
        Leet187RepeatedDNASequences xx = new Leet187RepeatedDNASequences();
        System.out.println(xx.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> r = new HashSet<>();
        Set<String> x = new HashSet<>();
        for ( int i=0; i < s.length()-9; i ++){
            if (!x.add(s.substring(i,i+10))) {
                r.add(s.substring(i, i + 10));
            }
        }
        return new ArrayList<>(r);
    }
}

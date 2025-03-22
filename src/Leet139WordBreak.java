
import java.util.*;

/**
 * Created by liuxz on 17-3-14.
 */
public class Leet139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] vec = new boolean[s.length()+1];
        vec[0]=true;
        for (int i = 0 ; i < s.length(); i ++){
            if (vec[i]) {
                for (String w : wordDict) {
                    if ((i+w.length()<=s.length())&&(Objects.equals(s.substring(i, i + w.length()), w)))
                        vec[i + w.length()] = true;
                }
            }
        }
        return vec[s.length()];
    }

    public static void main(String[] args){
        Leet139WordBreak xx = new Leet139WordBreak();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("lee");
        wordDict.add("tc");
        wordDict.add("ode");
        System.out.println(xx.wordBreak(s,wordDict));
    }

}

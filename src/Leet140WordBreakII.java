import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by liuxz on 17-3-14.
 */
public class Leet140WordBreakII {
//    not AC
    public List<String> wordBreak(String s, List<String> wordDict) {
        boolean[] vec = new boolean[s.length()+1];
        Map<Integer,List<String>> word = new HashMap<>(s.length());
        vec[0]=true;
        for (int i = 0 ; i <= s.length(); i ++){
            word.put(i, new LinkedList<>());
        }
        for (int i = 0 ; i < s.length(); i ++){
            if (vec[i]) {
                for (String w : wordDict) {
                    if ((i+w.length()<=s.length())&&(Objects.equals(s.substring(i, i + w.length()), w)))
                    {
                        vec[i + w.length()] = true;

                        if (word.get(i).size()==0){
                            word.get(i+w.length()).add(w);
                        }else{
                            for (String w2:word.get(i)){
                                word.get(i+w.length()).add(w2+" "+w);
                            }
                        }
                    }
                }
            }
        }
        return word.get(s.length());
    }

    public static void main(String[] args){
        Leet140WordBreakII xx = new Leet140WordBreakII();
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(xx.wordBreak(s,wordDict));
    }
}

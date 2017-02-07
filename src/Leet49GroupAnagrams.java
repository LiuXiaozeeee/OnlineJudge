import java.util.*;

/**
 * Created by liuxz on 17-2-7.
 */
public class Leet49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> result = new HashMap<>();
        for (String s : strs){

            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String st = new String(ch);

            if(result.containsKey(st)){
                result.get(st).add(s);
            }else{
                result.put(st,new ArrayList<String>(Collections.singletonList(s)));
            }
        }
        return new ArrayList<List<String>>(result.values());
    }

    public static void main(String[] args){
        Leet49GroupAnagrams xx = new Leet49GroupAnagrams();
        List<List<String>> result = xx.groupAnagrams(new String[]{"hos","boo","nay","deb","wow","bop","bob",
                "brr","hey","rye","eve","elf","pup","bum","iva","lyx",
                "yap","ugh","hem","rod","aha","nam","gap","yea","doc","pen","job","dis","max","oho","jed","lye",
                "ram","pup","qua","ugh","mir","nap","deb","hog","let","gym","bye","lon","aft","eel","sol","jab"});
        System.out.println(result.toString());
    }

}

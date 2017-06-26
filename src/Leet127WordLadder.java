import java.util.*;

/**
 * Created by Liuxz on 2017/6/26.
 */
public class Leet127WordLadder {

    public static void main(String[] args){
        Leet127WordLadder xx = new Leet127WordLadder();
        System.out.println(xx.ladderLength("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(xx.ladderLength("a", "c",
                Arrays.asList("a","b","c")));
        System.out.println(xx.ladderLength("hot", "dog",
                Arrays.asList("hot","dog")));

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<Integer, Set<Integer>> map = processList(wordList);
        Map<Integer, Integer> touchMap = new HashMap<>();
        Set<Integer> untouchSet = new HashSet<>();
        for (int i = 0 ; i < wordList.size(); i ++){untouchSet.add(i);}
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i< wordList.size();i ++){
            if (isOne(wordList.get(i),beginWord)){
                queue.add(i);
                untouchSet.remove(i);
                touchMap.put(i,1);
            }
        }
        while(!queue.isEmpty()){
            Integer x = queue.poll();
            Set<Integer> neighbor = map.get(x);
            for (Integer r:neighbor){
                if (!touchMap.keySet().contains(r)){
                    touchMap.put(r, (touchMap.get(x)+1));
                    queue.add(r);
                }
                if (Objects.equals(wordList.get(r), endWord))
                    return touchMap.get(r)+1;
            }
        }
        return 0;
    }

    private  Map<Integer, Set<Integer>> processList(List<String> wordList){
        int l = wordList.size();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i ++){
            Set<Integer> distance = new HashSet<>();
            for (int j = 0; j < wordList.size(); j ++) {
                if (isOne(wordList.get(i), wordList.get(j))) {
                    distance.add(j);
                }
            }
            map.put(i, distance);
        }
        return map;
    }

    private boolean isOne(String a, String b){
        if (a.length() != b.length()){
            return false;
        }
        int x=0;
        for (int i = 0 ; i < a.length(); i++){
            if (a.charAt(i) == b.charAt(i)){
                x ++;
            }
        }
        return (x == (a.length()-1));
    }
}

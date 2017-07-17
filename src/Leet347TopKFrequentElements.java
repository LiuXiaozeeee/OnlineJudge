import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liuxz on 2017/7/15.
 */
public class Leet347TopKFrequentElements {
    public static void main(String[] args){
        Leet347TopKFrequentElements xx = new Leet347TopKFrequentElements();
        List<Integer> result = xx.topKFrequent(new int[]{1,1,1,2,2,3},2);
        System.out.println(result);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int x:nums){
            if (m.containsKey(x)){m.put(x,m.get(x)+1);}
            else{
                m.put(x,1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i ++){
            Integer value = Integer.MIN_VALUE;
            Integer keys = nums[0];
            for (Map.Entry<Integer,Integer> iter: m.entrySet()){
                if (iter.getValue() > value){
                    value = iter.getValue();
                    keys = iter.getKey();
                }
            }
            result.add(keys);
            m.remove(keys);
        }
        return result;
    }
}

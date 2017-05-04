import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuxz on 17-5-4.
 */
public class Leet169MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mmp= new HashMap<>();
        int a = 0; int b = 0;
        for (int x:nums){
            if(!mmp.containsKey(x)){mmp.put(x, 1);}
            else{mmp.put(x, mmp.get(x)+1);}
            if (mmp.get(x) > b){
                b = mmp.get(x);
                a = x;
            }
        }
        return a;
    }
}

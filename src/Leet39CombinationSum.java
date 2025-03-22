
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Liuxz on 2017/1/24.
 */

public class Leet39CombinationSum {
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        List<List<Integer>> result = new ArrayList<>();
        loop(result, new ArrayList<Integer>(), 0,target);
        System.out.println(result);
        return result;
    }

    private void loop(List<List<Integer>> all, List<Integer> backup, int cur,int target){
        if (target <=0){
            return;
        }else{
            for (int i = cur ;i < candidates.length; i++){
                target = target - candidates[i];
                backup.add(candidates[i]);
                if (target == 0){
                    all.add(new ArrayList<Integer>(backup));
                }
                loop(all, backup, i,target);
                backup.remove(backup.size()-1);
                target = target + candidates[i];
            }
        }
    }


    public static void main (String[] args){
        Leet39CombinationSum x = new Leet39CombinationSum();
        x.combinationSum(new int[]{2,3,6,7}, 7);
    }
}

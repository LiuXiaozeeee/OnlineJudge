import jdk.internal.org.objectweb.asm.tree.IincInsnNode;

import java.util.*;
import java.util.jar.Pack200;

import static java.util.Arrays.asList;

/**
 * Created by Liuxz on 2017/1/26.
 */

public class Leet40CombinationSumII {
    int [] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates =  candidates;
        Arrays.sort(this.candidates);
        ArrayList<List<Integer>> result = new ArrayList<>();
        rec(result, new ArrayList<>(), 0, target);

        System.out.println(new HashSet<List<Integer>>(result));
        new ArrayList<List<Integer>>( new HashSet<List<Integer>>(result));
        return new ArrayList<List<Integer>>(new HashSet<List<Integer>>(result));
    }

    private void rec(List<List<Integer>> result, List<Integer> backup, int cur, int target){
        if (target<0){
            return ;
        }else{
            for(int i = cur; i < candidates.length; i ++){
                backup.add(candidates[i]);
                target= target-candidates[i];
                if (target == 0){
                    result.add(new ArrayList<>(backup));
                }
                rec(result, backup, i+1, target);
                target = target + candidates[i];
                backup.remove(backup.size() -1);
            }
        }

    }

    public static void main(String[] args){
        Leet40CombinationSumII xx = new Leet40CombinationSumII();
        xx.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
    }

}

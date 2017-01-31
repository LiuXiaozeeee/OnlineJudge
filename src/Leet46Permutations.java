import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Liuxz on 2017/1/31.
 */
public class Leet46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<List<Integer>> temp = new LinkedList<>();
        for (int i =0 ; i < nums.length ; i ++){
            result.add(new LinkedList<>(Arrays.asList(nums[i])));
        }
        for(int t = 0 ; t < nums.length-1;  t ++) {
            temp.clear();
            for (int i = 0; i < result.size(); i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (!result.get(i).contains(nums[j])) {
                        temp.add(new LinkedList<>(result.get(i)));
                        temp.get(temp.size() - 1).add(nums[j]);
                    }
                }
            }
            result = new LinkedList<>(temp);
        }
        return result;
    }
    static public void main(String[] args){
        Leet46Permutations xx = new Leet46Permutations();
        List<List<Integer>> result = xx.permute(new int []{1,2,3});
        System.out.println(result.toString());
    }

}

import java.util.*;

/**
 * Created by Liuxz on 2017/5/10.
 */
public class Leet78Subsets {
    int sum;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.sum = nums.length;
        this.nums = nums;
        Set<List<Integer>> result = new HashSet<>();
        loop(result, new LinkedList<>(), this.sum, 0);
        return new ArrayList<>(result);
    }

    private void loop(Set<List<Integer>> result, List<Integer>per, int least, int n ){
        if(least >= 0){result.add(new ArrayList<>(per));}else{return;}
        for (int i = n; i < this.sum ; i ++){
            per.add(this.nums[i]);
            loop(result,per,least-1,i+1);
            per.remove(per.size()-1);
        }
    }

    public static void main(String[] args){
        Leet78Subsets xx = new Leet78Subsets();
        System.out.println(xx.subsets(new int[]{1,2,3}));
    }
}

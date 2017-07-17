import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liuxz on 2017/7/3.
 */
public class Leet442FindAllDuplicatesinAnArray {
    public List<Integer> findDuplicates(int[] nums){
        List<Integer> r = new ArrayList<>();
        for (int i = 0 ; i < nums.length; i ++){
            if (nums[Math.abs(nums[i])-1]> 0){
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }else{
                r.add(Math.abs(nums[i]));
            }
        }
        return r;
    }
}

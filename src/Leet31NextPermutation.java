import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by liuxz on 17-1-13.
 */
public class Leet31NextPermutation {
    public void nextPermutation(int[] nums){

        int before,end = nums.length-1;
        for (before = end - 1; before >= 0 ; before --, end --) {
            if(nums[before] < nums[end]){
                break;
            }
        }
        int index = nums.length-1;
        if (before == -1){
            Arrays.sort(nums);
        }else{
            for (;nums[index] <= nums[before]; index -- );
            int temp = nums[before];
            nums[before] = nums[index];
            nums[index] = temp;
            Arrays.sort(nums, end, nums.length);
        }

        System.out.println(Arrays.toString(nums));
    }
    public static void  main(String[] args){
        Leet31NextPermutation x = new Leet31NextPermutation();
//        x.nextPermutation(new int[]{3,2,1});
//        x.nextPermutation(new int[]{2,2,2,2,3});
        x.nextPermutation(new int[]{1,5,1});
    }
}

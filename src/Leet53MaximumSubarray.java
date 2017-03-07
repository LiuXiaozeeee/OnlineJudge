import java.util.Arrays;

/**
 * Created by liuxz on 17-3-5.
 */
public class Leet53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int Dmax=nums[0];
        int Di=nums[0];
        for (int i =1 ; i<nums.length; i ++) {
            Di = (Di + nums[i]) > (nums[i]) ? (Di + nums[i]) : (nums[i]);
            if (Di > Dmax) {
                Dmax = Di;
            }
        }
        return Dmax;
    }

    public static void main(String[] args){
        Leet53MaximumSubarray xx = new Leet53MaximumSubarray();
        System.out.println(xx.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}

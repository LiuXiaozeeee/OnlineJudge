/**
 * Created by liuxz on 17-4-7.
 */
public class Leet152MaximumProductSubarray {
    public int maxProduct(int[] nums){
        int[] a = new int[nums.length];
        int[] x = new int[nums.length];
        int[] y = new int[nums.length];
        a[0]=nums[0];x[0]=nums[0];y[0]=nums[0];
        for (int i = 1 ; i < nums.length; i ++){
            x[i] = Math.max(nums[i],Math.max(x[i-1]*nums[i], y[i-1]*nums[i]));
            y[i] = Math.min(nums[i],Math.min(x[i-1]*nums[i], y[i-1]*nums[i]));
            a[i] = Math.max(a[i-1],Math.max(x[i],y[i]));

        }
        return a[nums.length-1];
    }

    public static void main(String[] args){
        Leet152MaximumProductSubarray xx = new Leet152MaximumProductSubarray();
        System.out.println(xx.maxProduct(new int[]{-1,-2,-3,-4}));
    }
}

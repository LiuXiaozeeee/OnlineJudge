import java.util.Arrays;

/**
 * Created by liuxz on 17-4-16.
 */
public class Leet238ProductofArrayExceptSelf  {

    public static void main(String[] args){
        Leet238ProductofArrayExceptSelf xx = new Leet238ProductofArrayExceptSelf();
        System.out.println(Arrays.toString(xx.productExceptSelf(new int[]{1,2,3,4})));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] order = new int[nums.length];
        int[] reverse = new int[nums.length];
        int[] result = new int[nums.length];
        for (int i = 0 ;i < nums.length; i ++){
            order[i] = (i==0)?nums[i]:order[i-1]*nums[i];
        }
        for (int i = nums.length-1; i>=0; i --){
            reverse[i] = (i == nums.length-1)?nums[i]:reverse[i+1]*nums[i];
        }
        for (int i = 0 ;i <nums.length;i ++){
            if (i ==0){
                result[i] = reverse[i+1];
            }else if (i == nums.length-1){
                result[i] = order[i-1];
            }else{
                result[i] = order[i-1]*reverse[i+1];
            }
        }
        return result;
    }

}

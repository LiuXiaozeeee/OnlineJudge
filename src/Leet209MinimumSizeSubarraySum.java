
/**
 * Created by Liuxz on 2017/8/22.
 */
public class Leet209MinimumSizeSubarraySum {
    public static void main(String[] args){
        Leet209MinimumSizeSubarraySum xx = new Leet209MinimumSizeSubarraySum();
        System.out.println(xx.minSubArrayLen(8, new int[]{2,3,1,2,4,3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int seq = Integer.MAX_VALUE;
        int head = 0;
        int tail = 0;
        int sum = 0;
        while(tail < nums.length){
            sum = sum + nums[tail];
            tail ++;
            while(sum >= s){
                seq = Math.min(tail-head, seq);
                sum = sum - nums[head];
                head ++;
            }
        }
        return seq== Integer.MAX_VALUE?0:seq;
    }
}

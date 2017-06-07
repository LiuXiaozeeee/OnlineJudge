import java.util.Arrays;

/**
 * Created by Liuxz on 2017/6/7.
 */
public class Leet300LongestIncreasingSubsequence {
    public  static void main(String[] args){
        Leet300LongestIncreasingSubsequence xx = new Leet300LongestIncreasingSubsequence();
//        System.out.println(xx.lengthOfLIS(new int[]{2,2}));
        System.out.println(xx.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(xx.lengthOfLIS(new int[]{-2,-1}));
//        System.out.println(xx.lengthOfLIS(new int[]{1,2,3,3,3,4,5,6,6,6,6,7,0}));
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}

import java.util.Arrays;

/**
 * Created by Liuxz on 2017/1/26.
 */

public class Leet41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        int i = 0, n = nums.length;
        while (i < n) {
            // If the current value is in the range of (0,length) and it's not at its correct position,
            // swap it to its correct position.
            // Else just continue;
            if (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i])
                swap(nums, i, nums[i]);
            else
                i++;
        }
        int k = 1;

        // Check from k=1 to see whether each index and value can be corresponding.
        while (k < n && nums[k] == k)
            k++;

        // If it breaks because of empty array or reaching the end. K must be the first missing number.
        if (n == 0 || k < n)
            return k;
        else   // If k is hiding at position 0, K+1 is the number.
            return nums[0] == k ? k + 1 : k;

    }

    public static void main(String[] args){
        Leet41FirstMissingPositive xx = new Leet41FirstMissingPositive();
        System.out.println(xx.firstMissingPositive(new int []{2,2,2,1}));
    }

    private void swap(int[] nums, int a, int b){
        int temp ;
        temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}

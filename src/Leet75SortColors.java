import java.util.Arrays;

/**
 * Created by liuxz on 17-5-3.
 */
public class Leet75SortColors {
    public void sortColors(int[] nums) {
        int begin=0;
        int cur = 0;
        int last = nums.length-1;

        while(cur <= last){
            if (nums[cur] == 0){
                swap(nums, begin, cur);
                begin ++;
                if (nums[cur] == 0){cur++;}
            }
            else if (nums[cur] == 1){
                cur++;
            }else {
                swap(nums, cur, last);
                last --;
            }
        }
    }

    public static  void main(String[] args){
        Leet75SortColors xx = new Leet75SortColors();
        int[] input = new int[]{0,0,0,1,1,1,2,2,1,2,2,1,1,1,1,0,0,0,0,0,0};
        xx.sortColors(input);
        System.out.println(Arrays.toString(input));
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

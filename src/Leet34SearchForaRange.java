import java.util.Arrays;

/**
 * Created by liuxz on 17-1-19.
 */
public class Leet34SearchForaRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1,-1};
        }
        int left = findLeft(nums, target);
        int right = findRigth( nums, target);
        return new int[]{left, right};
    }


    private int findLeft(int[] nums, int target){
        int left = 0 , right = nums.length-1;
        int mid = 0;
        while (left < right -1){
            mid = (left +right)/2;
            if(target<=nums[mid]){
                right = mid;
            }else{
                left = mid;
            }
        }
        if (nums[left] == target){
            return left;
        }else if (nums[right] == target ){
            return right;
        }else{
            return -1;
        }
    }

    private int findRigth(int[] nums, int target){
        int left = 0 , right = nums.length-1;
        int mid = 0;
        while (left < right -1){
            mid = (left +right)/2;
            if(target<nums[mid]){
                right = mid;
            }else {
                left = mid;
            }
        }
        if (nums[right] == target){
            return right;
        }else if (nums[left] == target){
            return left;
        }else{
            return -1;
        }
    }

    public static void main(String[] args){
        Leet34SearchForaRange x = new Leet34SearchForaRange();
        System.out.println(Arrays.toString(x.searchRange(new int[]{1,1,1,1,1,1,1,1,2,2,2,2,2},2)));
        System.out.println(Arrays.toString(x.searchRange(new int[]{5,7,7,8,8,10},8)));
        System.out.println(Arrays.toString(x.searchRange(new int[]{1,2,3,4,},0)));
        System.out.println(Arrays.toString(x.searchRange(new int[]{1},1)));

    }
}

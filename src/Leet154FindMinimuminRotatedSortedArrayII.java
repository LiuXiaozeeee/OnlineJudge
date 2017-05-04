import java.util.Arrays;

/**
 * Created by liuxz on 17-5-4.
 */
public class Leet154FindMinimuminRotatedSortedArrayII {
    public static void main(String[] args){
        Leet154FindMinimuminRotatedSortedArrayII xx = new Leet154FindMinimuminRotatedSortedArrayII();
        System.out.println(xx.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(xx.findMin(new int[]{1,1,1,0,1,1,1,1,1,1,1}));
    }
    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }

    private int binarySearch(int[] nums, int a, int b){
        if ((a ==b)||(a == b-1)){
            return Math.min(nums[a],nums[b]);
        }
        int mid = (a+b)/2;
        if (nums[mid] < nums[a]){
            return binarySearch(nums, a, mid);
        }else if (nums[b]<nums[mid]){
            return binarySearch(nums, mid, b);
        }else {
            return Math.min(binarySearch(nums, a, mid), binarySearch(nums, mid, b));
        }

    }
}

/**
 * Created by liuxz on 17-5-4.
 */
public class Leet162FindPeakElement {
    public static void main(String[] args){
        Leet162FindPeakElement xx = new Leet162FindPeakElement();
        System.out.println(xx.findPeakElement(new int[]{1,2,3,4,5,6,1}));
        System.out.println(xx.findPeakElement(new int[]{1,2,3,4,5,6,7}));
        System.out.println(xx.findPeakElement(new int[]{1,0,0,0,0,0,0}));

    }

    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }

    private int binarySearch(int[] nums, int a, int b){
        if ((a == b) ||(a == b-1)){
            return nums[a]>nums[b]?a:b;
        }
        int mid1 = (a+b)/2;
        int mid2 = mid1+1;
        if (nums[mid1] <nums[mid2]){
            return binarySearch(nums, mid2, b);
        }else{
            return  binarySearch(nums, a, mid1);
        }
    }
}

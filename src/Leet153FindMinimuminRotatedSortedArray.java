/**
 * Created by liuxz on 17-1-17.
 */
public class Leet153FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums){
        int begin=0, end=nums.length-1;
        if (nums[begin] < nums[end]){
            return nums[begin];
        }
        while(begin<end-1){
            int mid = (begin+end)/2;
            if (nums[begin] == nums[end]){
                end --;
            }else{
                if (nums[begin]<=nums[mid]) {
                    begin = mid;
                }else{
                    end = mid;
                }
            }
        }
        if(nums[begin]>nums[end]){
            return nums[end];
        }else{
            return nums[begin];
        }
    }
    public static void main(String[] args){
        Leet153FindMinimuminRotatedSortedArray x = new Leet153FindMinimuminRotatedSortedArray();
        System.out.println(x.findMin(new int[]{1,2,3}));
        System.out.println(x.findMin(new int[]{1,2,1}));
        System.out.println(x.findMin(new int[]{2,1,2}));
        System.out.println(x.findMin(new int[]{1,1,1,2,1,1,1,1}));
        System.out.println(x.findMin(new int[]{7,1,2,3,4,5,6}));
        System.out.println(x.findMin(new int[]{2,3,4,5,6,7,1}));
    }
}

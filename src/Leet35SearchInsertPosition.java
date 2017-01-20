/**
 * Created by liuxz on 17-1-19.
 */
public class Leet35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int begin=0, end=nums.length-1;
        int mid = 0;
        if (target <=  nums[begin]){
            return begin;
        }else if (target > nums[end]){
            return nums.length;
        }else{
            while(begin<end-1){
                mid = begin+(end-begin)/2;
                if(nums[mid] < target){
                    begin = mid;
                }else{
                    end = mid;
                }
            }
        }
        return end;
    }
    public static void main(String[] args){
        Leet35SearchInsertPosition x = new Leet35SearchInsertPosition();
        System.out.println(x.searchInsert(new int[]{1,3,5,6}, 6));
        System.out.println(x.searchInsert(new int[]{1,3,5,6}, 1));
        System.out.println(x.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(x.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(x.searchInsert(new int[]{1,2}, 1));
    }
}

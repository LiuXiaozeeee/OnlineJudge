/**
 * Created by liuxz on 17-1-17.
 */
public class Leet33SearchinRotatedSortArray {
    public int search(int[] nums, int target) {
        int begin = 0 , end = nums.length-1;
        while(begin < end-1){
            int mid = (begin+end)/2;
            if (nums[mid] <= nums[end]){
                if ((nums[mid] <= target)&&(target <=nums[end])){
                    begin = mid;
                }else{
                    end = mid;
                }
            }else{
                if ((nums[begin]<=target)&&(target<=nums[mid])){
                    end = mid;
                }else{
                    begin = mid;
                }
            }
        }
        if (nums[begin] == target) {
            return begin;
        } else if (nums[end] == target) {
            return end;
        }else{
            return -1;
        }
    }

    public static void main(String[] args){
        Leet33SearchinRotatedSortArray x = new Leet33SearchinRotatedSortArray();
        System.out.println(x.search(new int[]{3,4,5,0,1}, 6));
    }
}

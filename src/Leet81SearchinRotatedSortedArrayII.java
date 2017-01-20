/**
 * Created by liuxz on 17-1-17.
 */
public class Leet81SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int begin = 0 , end = nums.length-1;
        while (begin < end-1){
            if (nums[begin] == nums[end]){
                if (nums[begin] == target){
                    return true;
                }
                begin = begin+1;
                end = end-1;
            } else{
                int mid = (begin+end)/2;
                if (nums[mid]<=nums[end]){
                    if ((nums[mid]<=target)&&(target<=nums[end])){
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
        }
        return ((nums[begin] == target)||(nums[end]==target));

    }

    public static void main(String[] args){
        Leet81SearchinRotatedSortedArrayII x = new Leet81SearchinRotatedSortedArrayII();
        System.out.println(x.search(new int[]{1,1,1,1,1,1,2,1},2));
        System.out.println(x.search(new int[]{4,5,6,0,1,2},2));
        System.out.println(x.search(new int[]{4,5,6,0,1,2},0));
        System.out.println(x.search(new int[]{1,2,1},1));
    }

}

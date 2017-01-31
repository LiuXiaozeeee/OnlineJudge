/**
 * Created by Liuxz on 2017/1/31.
 */
public class Leet45JumpGameII {
    int gap = 0;
    int [] nums;
    public int jump(int[] nums) {
        this.nums = nums;
        subp(nums.length-1);
        return this.gap;
    }

     void subp(int end){
        for (int i =0 ; i < end ; i ++){
            if ( nums[i] + i >= end){
                if (i == 0){
                    this.gap ++;
                }else{
                    this.gap ++;
                    subp(i);
                }
                break;
            }
        }
     }

     static public void main(String[] args){
         Leet45JumpGameII xx = new Leet45JumpGameII();
         System.out.println(xx.jump(new int[]{2,3,1,1,4}));
     }

}

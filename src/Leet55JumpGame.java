/**
 * Created by liuxz on 17-3-19.
 */
public class Leet55JumpGame {
    public boolean canJump(int[] nums) {
        int l = 0;
        for(int index = 0; ; index ++){
            l = Math.max(l, index +nums[index]);
            if (l >= nums.length-1){
                return true;
            }
            if (l == index){
                return false;
            }
        }
    }

    public static void main(String[] args){
        Leet55JumpGame xx = new Leet55JumpGame();
        System.out.println(xx.canJump(new int[]{0}));

    }

}

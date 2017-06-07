/**
 * Created by Liuxz on 2017/6/7.
 */
public class Leet303RangeSumQueryImmutable {

    int [] calcBoard;
    int [] nums;
    public Leet303RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        this.calcBoard = new int[n];
        for (int i = 0 ; i < n; i ++){
            if (i == 0){calcBoard[i] = nums[i];}
            else {calcBoard[i] = calcBoard[i-1]+nums[i];}
        }
    }

    public int sumRange(int i, int j) {
        return calcBoard[j]-calcBoard[i]+ this.nums[i];
    }

    public static void main(String[] args){
        Leet303RangeSumQueryImmutable xx = new Leet303RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(xx.sumRange(0,2));
        System.out.println(xx.sumRange(2,5));
        System.out.println(xx.sumRange(0,5));
    }

}

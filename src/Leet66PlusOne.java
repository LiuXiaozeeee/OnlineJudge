import java.util.Arrays;

/**
 * Created by liuxz on 17-5-3.
 */
public class Leet66PlusOne {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        int flag = 1;
        for(int cur  = l-1; cur >= 0 ; cur --){
            if (flag + digits[cur] < 10){
                digits[cur] = digits[cur] + flag;
                flag = 0;
                break;
            }else{
                digits[cur] = 0;
                flag = 1;
            }
        }
        if (flag  == 1){
            int[] temp = new int[1 + digits.length];
            temp[0]=1;
            return temp;
        }else {
            return digits;
        }
    }


    public static void main(String[] args){
        Leet66PlusOne xx = new Leet66PlusOne();
        System.out.println(Arrays.toString(xx.plusOne(new int[]{9,9,9,9})));
    }
}

import java.util.Scanner;

/**
 * Created by Liuxz on 2017/7/19.
 */
public class hiho0 {
    public static void main(String[] arggs) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int[] input = new int[l];
        for(int index = 0; index < l ; index ++){
            input[index] = in.nextInt();
        }
        hiho0 x = new hiho0();
        System.out.println(x.ArrayPartition(input));
    }

    private int ArrayPartition(int[] input){
        int res = 0;
        int l = input.length;
        long[] sum = new long[l];
        sum[0] = input[0];
        for (int i = 1; i < l; i ++){
            sum[i] = sum[i-1] + input[i];
        }

        for (int a_1 = 0 ; a_1 < l ; a_1 ++){
            for (int a_2 = a_1+1; a_2 < l ; a_2 ++){
                long a = sum[a_1];
                long b = sum[a_2] - sum[a_1];
                long c = sum[sum.length-1] -sum[a_2];
                if ((Math.abs(a-b) <=1) &&
                        (Math.abs(a-c)<=1) &&
                        (Math.abs(b-c)<=1)){
                res ++;
                }
            }
        }
        return res;
    }

}


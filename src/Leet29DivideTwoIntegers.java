import java.util.ArrayList;
import java.util.List;

public class Leet29DivideTwoIntegers {
    public long divide(long dividend, long divisor) {

        long count = 0;
        int ctrl;
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (((dividend > 0) && (divisor > 0)) || ((dividend < 0) && (divisor < 0))) {
            ctrl = 1;
        } else {
            ctrl = -1;
        }

        List<long[]> divisorList = new ArrayList<>();

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        divisorList.add(new long[]{1, divisor});
        while (divisorList.get(0)[1] <= dividend) {
            int lastIndex = divisorList.size() - 1;
            if (divisorList.get(lastIndex)[1] <= dividend) {
                count = count + divisorList.get(lastIndex)[0];
                dividend = dividend - divisorList.get(lastIndex)[1];
                divisorList.add(new long[]{divisorList.get(lastIndex)[0] + divisorList.get(lastIndex)[0],
                        divisorList.get(lastIndex)[1] + divisorList.get(lastIndex)[1]});
            } else {
                for (int i = lastIndex; i >= 0; i--) {
                    if (divisorList.get(i)[1] <= dividend) {
                        count = count + divisorList.get(i)[0];
                        dividend = dividend - divisorList.get(i)[1];
                        break;
                    }
                }
            }
        }
        if (Integer.MAX_VALUE < (count * ctrl)) {
            return Integer.MAX_VALUE;
        } else {
            return (int) (count * ctrl);
        }
    }


    public static void main(String[] args) {
        Leet29DivideTwoIntegers test = new Leet29DivideTwoIntegers();
//        System.out.println(test.divide(5, 2));
        System.out.println(test.divide(-2147483648, -1));
        System.out.println(test.divide(3, 3));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
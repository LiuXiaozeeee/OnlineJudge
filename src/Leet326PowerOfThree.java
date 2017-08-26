/**
 * Created by Liuxz on 2017/8/14.
 */
public class Leet326PowerOfThree {
    public static void main(String[] args){
        Leet326PowerOfThree xx = new Leet326PowerOfThree();
        xx.isPowerOfThree(3);
    }

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}

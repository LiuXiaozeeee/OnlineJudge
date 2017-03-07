/**
 * Created by liuxz on 17-3-5.
 */
public class Leet70ClimbingStairs {
    public int climbStairs(int n) {
        int [] vec = new int[n+1>3?n+1:3];
        vec[1] = 1;
        vec[2] = 2;
        for (int i = 3; i <= n; i++) {
            vec[i] = vec[i-1]+vec[i-2];
        }
        return vec[n];
    }
}

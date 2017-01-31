import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Liuxz on 2017/1/27.
 */
public class Leet42TrappingRainWater {
    public int trap(int[] height) {
        List<Integer> stack = new ArrayList<>();
        stack.add(-1);
        for (int i = 0 ; i < height.length; i ++){
            stack.add(height[i]);
        }
        int volumn = 0;
        int left = 0;
        for(int i = 1 ; i < stack.size() ; i ++){
            if (stack.get(i-1)<stack.get(i)){
                volumn += calc(left, i, stack);
            }
            if (stack.get(i) > stack.get(left)){
                left = i;
            }
        }
        return volumn;
    }

    private int calc( int left, int right, List<Integer> height ){
        int value = 0;
        int altitude = Math.min(height.get(left), height.get(right));
        for (int i = left+1; i < right ; i ++){
            if(height.get(i)<altitude){
                value += altitude-height.get(i);
                height.set(i,altitude);
            }
        }
        return value;
    }


    public static void main(String[] args){
        Leet42TrappingRainWater x = new Leet42TrappingRainWater();
        System.out.println(x.trap(new int[] {5,2,1,2,1,5}));
    }
}

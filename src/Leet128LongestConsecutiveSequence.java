import java.util.HashSet;
import java.util.Set;

/**
 * Created by Liuxz on 2017/6/11.
 */
public class Leet128LongestConsecutiveSequence {
    Set<Integer> a = new HashSet<>();

    public static void main(String[] args){
        Leet128LongestConsecutiveSequence xx =  new Leet128LongestConsecutiveSequence();
        System.out.println(xx.longestConsecutive(new int[]{100}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        for (int x: nums){
            a.add(x);
        }
        int max =1;
        for (int x :nums){
            if (a.contains(x)){
                int temp = 1+left(x) + right(x);
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    int left(int x){
        x = x-1;
        int num = 0;
        while(a.contains(x)){
            num++;
            a.remove(x);
            x --;
        }
        return num;
    }


    int right(int x){
        x = x+1;
        int num = 0;
        while(a.contains(x)){
            num++;
            a.remove(x);
            x ++;
        }
        return num;
    }

}

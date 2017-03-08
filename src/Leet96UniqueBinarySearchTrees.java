import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuxz on 17-3-9.
 */
public class Leet96UniqueBinarySearchTrees {
    public int numTrees(int n) {
        Map<Integer,Integer> g = new HashMap<>(n+1);
        g.put(0,1);g.put(1,1);
        for (int i = 1; i <= n; i ++){
            int values = 0;
            for (int j = 0 ; j < i ; j ++){
                values+=g.get(j)*g.get(i-1-j);
            }
            g.put(i,values);
        }
        return g.get(n);
    }

    public static void main(String[] args){
        Leet96UniqueBinarySearchTrees xx = new Leet96UniqueBinarySearchTrees();
        System.out.println(xx.numTrees(4));
    }
}

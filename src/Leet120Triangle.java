import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuxz on 17-3-9.
 */
public class Leet120Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int h = triangle.size();
        Integer[] l = new Integer[h];
        triangle.get(triangle.size()-1).toArray(l);
        for (int i = h-2;i >=0;i--){
            for (int j =0 ; j <=i ; j ++){
                l[j]=Math.min(l[j],l[j+1])+triangle.get(i).get(j);
            }
        }
        return l[0];
    }

    public static void main(String[] args){
        Leet120Triangle xx = new Leet120Triangle();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1));
        input.add(Arrays.asList(3,4));
        input.add(Arrays.asList(6,5,7));
        input.add(Arrays.asList(4,1,8,3));
        System.out.println(xx.minimumTotal(input));
    }

}

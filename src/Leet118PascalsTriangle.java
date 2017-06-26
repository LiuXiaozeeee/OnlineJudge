import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Liuxz on 2017/6/26.
 */
public class Leet118PascalsTriangle {
    public static void main(String[] args){
        Leet118PascalsTriangle xx = new Leet118PascalsTriangle();
        List<List<Integer>> result = xx.generate(5);
        System.out.println(Arrays.deepToString(result.toArray()));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0 ; i < numRows; i++){
            List<Integer> temp = new ArrayList<>(i+1);
            for (int j = 0; j <= i; j ++){
                if(j == 0){
                    temp.add(1);
                }else if (j == i){
                    temp.add(1);
                }else{
                    temp.add(result.get(result.size()-1).get(j-1)
                            + result.get(result.size()-1).get(j));
                }
            }
            result.add(new ArrayList<>(temp));
        }
        return result;
    }
}

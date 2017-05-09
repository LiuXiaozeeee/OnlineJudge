import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Liuxz on 2017/5/9.
 */
public class Leet77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        loop(result,new ArrayList<>(), 1 , n, k);
        return result;
    }
    void loop(List<List<Integer>> result, List<Integer> vec, int input,int n, int k){
        if(vec.size() == k){result.add(new ArrayList<>(vec));return;}
        for (int i = input; i<=n;i ++){
            vec.add(i);
            loop(result, vec, i+1,n,k);
            vec.remove(vec.size()-1);
        }
    }

    public static void main(String[] args){
        Leet77Combinations xx = new Leet77Combinations();
        List<List<Integer>> result = xx.combine(4,3);
    }
}

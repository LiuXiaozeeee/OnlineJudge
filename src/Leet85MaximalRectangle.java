import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by liuxz on 17-3-7.
 */
public class Leet85MaximalRectangle {

    public static void main(String[] args){
        Leet85MaximalRectangle xx = new Leet85MaximalRectangle();
        System.out.println(xx.maximalRectangle(new char[][]{
                new char[]{'1','0','1','0','0'},
                new char[]{'1','0','1','1','1'},
                new char[]{'1','1','1','1','1'},
//                new char[]{'1','1','1','1','1'},
                new char[]{'1','0','0','1','0'}
        }));

//        System.out.println(xx.maximalRectangle());
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length;
        List<List<Integer>> cumMatrix = new ArrayList<>();
        for (char[] aMatrix : matrix) {
            cumMatrix.add(cumsum(aMatrix));
        }
        int[] h = new int[m];
        int max = 0 ;
        for (int in =0 ;in < n ; in ++){
            for (int im =0; im < m ; im ++){
                h[im]=cumMatrix.get(im).get(in);
            }
            int temp = largestRectangleArea(h);
            max = max>temp?max:temp;
        }

        return max;
    }



    private List<Integer> cumsum(char[] input){
        int l = input.length;
        List<Integer> r = new ArrayList<>(l);
        int c = 0;
        for(char x : input){
            if (x == '0'){
                r.add(0);
                c = 0;
            }else{
                c+=1;
                r.add(c);
            }
        }
        return r;
    }

    private int largestRectangleArea(int[] heights) {
        int max = 0;
//        List<Integer> h = IntStream.of(heights).boxed().collect(Collectors.toList());
        List<Integer> h = new ArrayList<>();
        for (int i = 0 ; i < heights.length; i++){
            h.add(heights[i]);
        }
        h.add(0,-1);h.add(-1);
        LinkedList<Integer> heightStack = new LinkedList<>();
        LinkedList<Integer> indexStack = new LinkedList<>();
        for (int i = 0 ; i < h.size();i++){
            if (i == 0 ){
                heightStack.push(h.get(i));
                indexStack.push(i);
            }else{
                int lastIndex = i;
                while (heightStack.peek() > h.get(i)){
                    lastIndex = indexStack.pop();
                    int temp = heightStack.pop()*(i-lastIndex);
                    if (temp >max){
                        max = temp;
                    }
                }
                heightStack.push(h.get(i));
                indexStack.push(lastIndex);
            }
        }
        return max;
    }

}

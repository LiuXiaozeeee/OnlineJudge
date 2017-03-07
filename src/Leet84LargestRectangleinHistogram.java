import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by liuxz on 17-3-7.
 */
public class Leet84LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
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

    public static void main(String[] args){
        Leet84LargestRectangleinHistogram xx = new Leet84LargestRectangleinHistogram();
        System.out.println(xx.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}

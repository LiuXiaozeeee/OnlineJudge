
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by liuxz on 16-12-12.
 */

class BerylliumSphere{
    private static long counter;
    private final long id = counter++;
    public String toString(){
        return "Sphere" + id;
    }
}

public class test {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.deepToString(new int[][]{
                new int[]{1,2},
                new int[]{3,4}
        }));
//        List<Integer> a = new ArrayList<>();a.add(1);a.add(2);a.add(3);
//        List<Integer> b = new ArrayList<>();b.add(1);b.add(2);b.add(3);
//        Set<List<Integer>> c = new HashSet<>();
//        c.add(a);c.add(b);
//        List<List<Integer>> d = new ArrayList<>(c);
//        System.out.println(d);
    }

//    private void change(List<Integer> abcc, int index){
//        abcc.set(index,0);
//    }
//
//    private void testx (){
//        List<Integer> abcc = new ArrayList<>();
//        abcc.addAll(Arrays.asList(1,2,3,3,3,3,3,4));
//        change(abcc,3);
//        System.out.println(abcc.toString());
//    }
}


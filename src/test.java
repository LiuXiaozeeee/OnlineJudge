import javafx.beans.property.ReadOnlyIntegerWrapper;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntBinaryOperator;

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
    public static void main(String[] args){
        List<Integer> temp = new LinkedList<>(Arrays.asList(1,2,3,4));
        System.out.println(temp.contains(1));
        List<List<Integer>> tempxx = new LinkedList<>();
        tempxx.add(new LinkedList<>(Arrays.asList(1,2,3,4)));
        System.out.println(tempxx.toString());
    }

    private void change(List<Integer> abcc, int index){
        abcc.set(index,0);
    }

    private void testx (){
        List<Integer> abcc = new ArrayList<>();
        abcc.addAll(Arrays.asList(1,2,3,3,3,3,3,4));
        change(abcc,3);
        System.out.println(abcc.toString());
    }
}


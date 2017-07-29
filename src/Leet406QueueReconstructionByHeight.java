import java.util.*;

/**
 * Created by Liuxz on 2017/7/29.
 */
public class Leet406QueueReconstructionByHeight {
    public static void main(String[] args){
        Leet406QueueReconstructionByHeight xx = new Leet406QueueReconstructionByHeight();
        System.out.println(Arrays.deepToString(xx.reconstructQueue(new int[][]{
                new int[]{7,0},
                new int[]{4,4},
                new int[]{7,1},
                new int[]{5,0},
                new int[]{6,1},
                new int[]{5,2}
        })));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o2[0] - o1[0];
                }
            }
        });

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i<people.length; i ++) {
            result.add(people[i][1], people[i]);
        }
        return (result.toArray(new int[result.size()][]));
    }
}

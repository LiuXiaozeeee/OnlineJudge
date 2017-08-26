import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Liuxz on 2017/8/22.
 */
public class Leet200NumberofIslands {
    char[][] grid;
    int result;

    public static void main(String[] args){
        Leet200NumberofIslands xx =new Leet200NumberofIslands();
        System.out.println(
                xx.numIslands(new char[][]{
                        new char[]{'1','1','1','1','0'},
                        new char[]{'1','1','0','1','0'},
                        new char[]{'1','1','0','0','0'},
                        new char[]{'0','0','0','0','0'}})
        );
        System.out.println(
                xx.numIslands(new char[][]{
                        new char[]{'1','1','0','0','0'},
                        new char[]{'1','1','0','0','0'},
                        new char[]{'0','0','1','0','0'},
                        new char[]{'0','0','0','1','1'}})
        );
    }


    public int numIslands(char[][] grid) {

        if ((grid.length ==0)||(grid[0].length ==0)){
            return 0;
        }

        this.grid = grid;
        this.result = 0;
        while(true){
            pair pos = isAnyIslandExists();
            if (pos == null){
                return result;
            }else{
                calcOnce(pos);
                result ++;
            }
        }
    }

    private void calcOnce( pair pos){
        LinkedList<pair> backup = new LinkedList<>();
        Set<pair> pool = new HashSet<>();
        backup.add(pos);
        pool.add(pos);
        while(!backup.isEmpty()){
            pair temp = backup.pollLast();
            grid[temp.x][temp.y] = '0';
            pair cur ;

            cur = new pair(temp.x-1,temp.y);
            if (isCurrentIslandExists(cur) &&!pool.contains(cur)){
                backup.push(cur);
                pool.add(cur);
            }
            cur = new pair(temp.x,temp.y-1);
            if (isCurrentIslandExists(cur) &&!pool.contains(cur)){
                backup.push(cur);
                pool.add(cur);
            }
            cur = new pair(temp.x+1,temp.y);
            if (isCurrentIslandExists(cur) &&!pool.contains(cur)){
                backup.push(cur);
                pool.add(cur);
            }
            cur = new pair(temp.x,temp.y+1);
            if (isCurrentIslandExists(cur) &&!pool.contains(cur)){
                backup.push(cur);
                pool.add(cur);
            }
        }

    }

    private pair isAnyIslandExists(){
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0;j < grid[0].length; j ++){
                if (grid[i][j] == '1'){
                    return new pair(i,j);
                }
            }
        }
        return null;
    }

    private boolean isCurrentIslandExists(pair pos){
        if ((pos.x < 0) ||(pos.x>=grid.length) || (pos.y < 0) || (pos.y >= grid[0].length)){
            return false;
        }
        return grid[pos.x][pos.y] == '1';
    }

    class pair{
        int x;
        int y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            pair pair = (pair) o;

            if (x != pair.x) return false;
            return y == pair.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}

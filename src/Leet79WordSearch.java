import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Liuxz on 2017/5/10.
 */
public class Leet79WordSearch {
    String word;
    char[][] board;
    Set<position> result;
    int length;
    int width;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.length = board.length;
        this.width = board[0].length;
        this.result = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++)
                if (Objects.equals(this.board[i][j], this.word.charAt(0))) {
                    this.result.add(new position(i,j));
                    if (loop(i, j, 1)) {
                        return true;
                    }
                    this.result.remove(new position(i,j));
                }
        }
        return false;
    }

    boolean loop(int i, int j, int depth){
        if (depth == this.word.length()){return true;}
        if((i-1>=0)&&(Objects.equals(this.board[i-1][j],this.word.charAt(depth)))
                &&(!this.result.contains(new position(i-1,j)))){
            this.result.add(new position(i-1,j));
            if (loop(i-1, j,depth+1)){return true;}
            this.result.remove(new position(i-1,j));
        }
        if((i+1<this.length)&&(Objects.equals(this.board[i+1][j],this.word.charAt(depth)))
                &&(!this.result.contains(new position(i+1,j)))){
            this.result.add(new position(i+1,j));
            if(loop(i+1, j,depth+1)){return true;}
            this.result.remove(new position(i+1,j));
        }
        if((j-1>=0)&&(Objects.equals(this.board[i][j-1],this.word.charAt(depth)))
                &&(!this.result.contains(new position(i,j-1)))){
            this.result.add(new position(i,j-1));
            if(loop(i, j-1,depth+1)){return true;}
            this.result.remove(new position(i,j-1));
        }
        if((j+1<this.width)&&(Objects.equals(this.board[i][j+1],this.word.charAt(depth)))
                &&(!this.result.contains(new position(i,j+1)))){
            this.result.add(new position(i,j+1));
            if(loop(i, j+1,depth+1)){return true;}
            this.result.remove(new position(i,j+1));
        }
        return false;
    }

    public static void main(String[] args){
        Leet79WordSearch xx = new Leet79WordSearch();
//        System.out.println(
//            xx.exist(new char[][]{
//                    new char[]{'A','B','C','E'},
//                    new char[]{'S','F','C','S'},
//                    new char[]{'A','D','E','E'}
//            },"ABCB")
//        );
//        System.out.println(
//                xx.exist(new char[][]{
//                        new char[]{'A','B','C','E'},
//                        new char[]{'S','F','C','S'},
//                        new char[]{'A','D','E','E'}
//                },"ABCCED")
//        );
//        System.out.println(
//                xx.exist(new char[][]{
//                        new char[]{'A','B','C','E'},
//                        new char[]{'S','F','C','S'},
//                        new char[]{'A','D','E','E'}
//                },"SEE")
//        );
        System.out.println(
                xx.exist(new char[][]{
                        new char[]{'A','B'},
                        },"BA")
        );
    }
    private class position {
        int a;
        int b;

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        position(int a, int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof position){
                return (this.a == ((position)obj).getA())&&
                        (this.b == ((position)obj).getB());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.a*31+this.b;
        }
    }
}

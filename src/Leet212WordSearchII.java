import java.util.*;

/**
 * Created by Liuxz on 2017/5/24.
 */
public class Leet212WordSearchII {
    char[][] board;
    Set<pairWise> set = new HashSet<>();
    public static void main(String[] args){
        Leet212WordSearchII xx = new Leet212WordSearchII();
        List<String> res ;
        res = xx.findWords(new char[][]{
                new char[]{'o','a','a','n'},
                new char[]{'e','t','a','e'},
                new char[]{'i','h','k','r'},
                new char[]{'i','f','l','v'}
        }, new String[]{"oath","pea","eat","rain","oath","pea","eat","rain"});
        System.out.println(Collections.singletonList(res));

        res = xx.findWords(new char[][]{
                new char[]{'a','a'}
        }, new String[]{"aaa"});
        System.out.println(Collections.singletonList(res));
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        this.board = board;
        for(String word: words){
            if(findOneWord(word)){
                result.add(word);
            }
        }
        return new LinkedList<>(result);
    }

    private boolean findOneWord(String words){
        char[] w = words.toCharArray();
        for (int i =0; i<board.length; i ++){
            for(int j = 0; j <board[0].length ; j++ ){
                set.add(new pairWise(i,j));
                if (loopWord(w, 0, new pairWise(i,j))){
                    set.clear();
                    return true;
                }
                set.remove(new pairWise(i,j));
            }
        }
        set.clear();
        return false;
    }

    private boolean loopWord(char[] w, int cur, pairWise pos){
        if(cur == w.length){return true;}
        if (!checkValid(pos)){return false;}
        if (board[pos.getA()][pos.getB()] != w[cur]){
            return false;
        }else{
            pairWise a;
            a = turnLeft(pos);
            if (!set.contains(a)){
                set.add(a);
                if (loopWord(w,cur+1, a)){return true;}
                set.remove(a);
            }
            a = turnRight(pos);
            if (!set.contains(a)){
                set.add(a);
                if (loopWord(w,cur+1, a)){return true;}
                set.remove(a);
            }
            a = turnUp(pos);
            if (!set.contains(a)){
                set.add(a);
                if (loopWord(w,cur+1, a)){return true;}
                set.remove(a);
            }
            a = turnDown(pos);
            if (!set.contains(a)){
                set.add(a);
                if (loopWord(w,cur+1, a)){return true;}
                set.remove(a);
            }
            return false;
        }
    }

    private pairWise turnLeft(pairWise pos){
        return new pairWise(pos.getA()-1, pos.getB());
    }

    private pairWise turnRight(pairWise pos){
        return new pairWise(pos.getA()+1, pos.getB());
    }

    private pairWise turnUp(pairWise pos){
        return new pairWise(pos.getA(), pos.getB()-1);
    }

    private pairWise turnDown(pairWise pos){
        return new pairWise(pos.getA(), pos.getB()+1);
    }

    private boolean checkValid(pairWise pos){
        int a = pos.getA();
        int b = pos.getB();
        if (((0<=a) &&(a<board.length))&&((0<=b)&&(b<board[0].length))){
            return true;
        }else{
            return false;
        }
    }

    class pairWise {
        int a;
        int b;

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public pairWise(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof pairWise && (((pairWise) obj).a == this.a) && (((pairWise) obj).b == this.b);
        }
    }
}

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Created by liuxz on 17-1-15.
 */
public class Leet32LongestValidParentheses {
    public int longestValidParentheses(String s) {
        s = s+"#";
        Stack<struct> x= new Stack<>();
        x.add(new struct('*',-1));
        for (int i = 0 ; i < s.length(); i ++){
            if (iseq(x.peek().para, s.charAt(i))){
                x.pop();
            }else{
                x.push(new struct(s.charAt(i),i));
            }
        }

        int len = 1;
        for (int i = 1 ; i < x.size(); i ++){
            if ((x.get(i).index - x.get(i - 1).index)> len){
                len = (x.get(i).index - x.get(i - 1).index);
            }
        }

        return len - 1;
    }

    private boolean iseq(char a , char b){

        if ((a == '(') &&(b == ')')){
            return true;
        }else{
            return false;
        }
    }


    class struct implements Comparable<struct>{
        char para;
        int index;

        struct(char para, int index){
            this.para = para;
            this.index = index;
        }

        @Override
        public int compareTo(struct o) {
            return this.index - o.index;
        }
    }

    public static void main(String[] args){
        Leet32LongestValidParentheses x = new Leet32LongestValidParentheses();
        System.out.println(x.longestValidParentheses(")("));
    }

}

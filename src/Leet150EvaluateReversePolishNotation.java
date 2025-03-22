

import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by liuxz on 17-4-13.
 */
public class Leet150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i ++){
            if(isOperator(tokens[i])){
                int a = stack.pop();
                int b = stack.pop();
                if (Objects.equals(tokens[i],"+")){
                    stack.push(a+b);
                }else if (Objects.equals(tokens[i],"-")){
                    stack.push(b-a);
                }else if (Objects.equals(tokens[i],"*")){
                    stack.push(a*b);
                }else if (Objects.equals(tokens[i],"/")){
                    stack.push(b/a);
                }
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }

    private boolean isOperator(String input){
        if ((Objects.equals(input,"+"))||(Objects.equals(input,"-"))||
                (Objects.equals(input,"*"))||(Objects.equals(input,"/"))){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        Leet150EvaluateReversePolishNotation xx = new Leet150EvaluateReversePolishNotation();
        System.out.println(xx.evalRPN(new String[]{"2","1","+","3","*"}));
    }
}

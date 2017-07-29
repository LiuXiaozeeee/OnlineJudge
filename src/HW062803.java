import java.util.*;

/**
 * Created by Liuxz on 2017/6/28.
 */
public class HW062803 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        HW062803 r = new HW062803();
        while (in.hasNextLine()){
            System.out.println(r.process(in.nextLine()));
        }
    }

    private String process(String input){
        String[] mix = input.split("\"");
        LinkedList<String> seq = new LinkedList<>();
        for (String temp : mix){if (Objects.equals(temp,"")){seq.add(temp);}}
        String temp = seq.poll();
        String result = helper(temp, seq);
        return "\"" + result +"\"";
    }

    private String helper(String operator, LinkedList<String> seq){
        if (operator.equals("Error")){
            System.out.println("Error");
            System.out.println(Arrays.toString(seq.toArray()));
        }
        if (operator.contains("search")){
            String args1 = seq.poll();
            if(!(args1.charAt(0) == '(')){
                args1 = helper(args1, seq);
            }
            String args2 = seq.poll();
            if (!(args2.charAt(0) == '(')){
                args2 = helper(args2, seq);
            }
            args1 = args1.substring(1, args1.length()-1);
            args2 = args2.substring(1, args2.length()-1);
            int r = args1.indexOf(args2);
            if(r == -1){return null;}
            else{
                return args1.substring(r);
            }
        }
        else if (operator.contains("combine")){
            LinkedList<String> args = new LinkedList<>();
            while(true){
                String temp =seq.poll();
                while(temp.charAt(0)=='('){
                    temp = helper(temp, seq);
                }
                if(temp.charAt(temp.length()-1) == ')'){
                    temp = temp.substring(0,temp.length()-2);
                    if(!Objects.equals(temp.trim(), "")){
                        args.add(temp);
                        break;
                    }
                }else{
                    args.add(temp);
                }
            }
            StringBuilder re = new StringBuilder();
            for (String temp : args){
                re.append(temp);
            }
            return re.toString();
        }
        else if (operator.contains("quote")){
            String args = seq.poll();
            while(args.charAt(0)=='('){
                args = helper(args, seq);
            }
            return args;
        }
        else if (operator.contains("reverse")){
            String args = seq.poll();
            while(args.charAt(0) == '('){
                args = helper(args, seq);
            }
            StringBuffer temp = new StringBuffer(args);
            return temp.reverse().toString();
        }
        else{
            return "Error";
            }
        }
}


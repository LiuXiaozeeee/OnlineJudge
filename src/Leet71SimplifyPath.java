import java.util.*;

/**
 * Created by liuxz on 17-3-21.
 */
public class Leet71SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> output = new Stack<>();
        String[] input = path.split("/");
        for (String x : input){
            if ((Objects.equals(x,"."))||(x.length()==0)){
                continue;
            } else if (Objects.equals(x, "..")){
                if (!output.empty()){
                    output.pop();
                }
            }else{
                output.push(x);
            }
        }
        StringBuilder f = new StringBuilder();
        f.append("/");
        for (String x: output){
            f.append(x);
            f.append("/");
        }
        if (f.length()!=1){
            f.deleteCharAt(f.length()-1);
        }
        return f.toString();
    }

    public static void main(String[] args){
        Leet71SimplifyPath xx = new Leet71SimplifyPath();
        System.out.println(xx.simplifyPath("/a/./b/../../c/"));
        System.out.println(xx.simplifyPath("/home/"));
        System.out.println(xx.simplifyPath("/../"));
        System.out.println(xx.simplifyPath("/home//foo/"));
    }
}

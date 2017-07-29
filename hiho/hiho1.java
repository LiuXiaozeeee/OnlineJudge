import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Liuxz on 2017/7/19.
 */
public class hiho1 {
    int smallDepth = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        for (int i=0; i <l ; i++){
            String a = in.next();
            String b = in.next();
            hiho1 x = new hiho1();
            System.out.println(x.msft(a ,b)-1);
        }
    }

    private int msft(String a, String b){
        msft(a,b,0,0);
        return smallDepth;
    }

    private void msft(String a, String b, int offset, int depth){
        if (offset == a.length()){
            smallDepth = Math.min(smallDepth, depth);
            return;
        }
        List<pair> candidate = calc_candidate(a,b,offset);
        for (pair c : candidate){
            msft(c.r, b, c.offset,depth+1);
        }
    }

    private List<pair> calc_candidate (String a, String b, int offset){
        List<pair> result = new ArrayList<>();
        int offset_a=-1;
        for (int i = offset; i < a.length(); i ++){
            if (a.charAt(i) != b.charAt(i)){
                offset_a = i;
                break;
            }
        }
        if (offset_a == -1){
            result.add(new pair(a,a.length()));
            return result;
        }
        for (int i = offset_a; i < a.length(); i ++){
            if (a.charAt(i) == b.charAt(offset_a)){
                result.add(new pair(swap(a,offset_a,i),
                        offset_a));
            }
        }

        return result;
    }

    private String swap (String a, int pos_1, int pos_2){
        char[] c = a.toCharArray();
        char temp = c[pos_2];
        c[pos_2] = c[pos_1];
        c[pos_1] = temp;
        return new String(c);
    }

    class pair{
        String r;
        int offset;
        pair(String r, int offset){
            this.r = r;
            this.offset = offset;
        }
    }
}


/**
 * Created by liuxz on 17-3-7.
 */
public class Leet91DecodeWays {
    public int numDecodings(String s) {
        if ((s.length() == 1)&&(check(s))) {
            return 1;
        }else if ((s.length() == 1)&&!check(s)){
            return 0;
        }else if(s.length() ==0 ){
            return 0;
        }

        int[] e = new int[s.length()];
        if (check(s.substring(0,1))){
            e[0] =1;
        }else{
            return 0;
        }

        if (check(s.substring(0,2))){
            e[1]+=1;
        }
        if (check(s.substring(1,2))){
            e[1]+=1;
        }
        if (e[1] == 0){
            return 0;
        }

        for (int i = 2 ; i < s.length(); i ++){
            if (check(s.substring(i-1,i+1))){
                e[i]=e[i] + e[i-2];
            }
            if(check(s.substring(i,i+1))){
                e[i]=e[i] + e[i-1];
            }
            if(e[i] == 0){
                return 0;
            }
        }
        return e[e.length-1];
    }

    private boolean check(String x){
        boolean b= (Integer.parseInt(x) <= 26)&&(1<=Integer.parseInt(x));
        if ((x.length() == 2)&&(Integer.parseInt(x)<10)){
            b = false;
        }
        return b;
    }

    public static void main(String[] args){
        Leet91DecodeWays xx = new Leet91DecodeWays();
        System.out.println(xx.numDecodings("101"));
    }
}

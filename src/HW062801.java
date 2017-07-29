import java.util.Scanner;

/**
 * Created by Liuxz on 2017/6/28.
 */
public class HW062801 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String x = in.nextLine();
            int[] result= new int[]{0,0,0};
            int lastState = -1;
            for (char r:x.toCharArray()){
                if (test(r) != lastState){
                    result[test(r)]++;
                }
                lastState = test(r);
            }
            System.out.println(result[0]+","+result[1]+","+result[2]);
        }
    }

    static int test(char input){
        if ((('a'<=input)&&(input <= 'z'))||(('A'<=input)&&(input<='Z'))){
            return 0;
        }else if(('0'<=input)&&(input<='9')){
            return 1;
        }else{
            return 2;
        }
    }
}

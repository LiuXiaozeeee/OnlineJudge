/**
 * Created by Liuxz on 2017/7/28.
 */
public class Leet367ValidPerfectSquare {
    public static void main(String[] args){
        Leet367ValidPerfectSquare xx = new Leet367ValidPerfectSquare();
        System.out.println(xx.isPerfectSquare(16));
        System.out.println(xx.isPerfectSquare(14));
        System.out.println(xx.isPerfectSquare(2147483647));
    }

    public boolean isPerfectSquare(int num){
        if(num == Integer.MAX_VALUE){
            return false;
        }
        return helper(0, num, num);
    }

    private boolean helper(int low, int high, int aim){
        while(true){
            if (((high -low) <= 1))
            {
                return !((high*high>aim)&&(low*low < aim));
            }
            int medium = (low+high)/2;
            if ((medium > 46341)||(medium*medium>aim)){
                high = medium;
            }else if (medium * medium <= aim) {
                low = medium;
            }
        }
    }
}

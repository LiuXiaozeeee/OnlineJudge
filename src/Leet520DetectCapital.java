/**
 * Created by Liuxz on 2017/7/28.
 */
public class Leet520DetectCapital {
    public static void main(String[] args){
        Leet520DetectCapital xx = new Leet520DetectCapital();
        System.out.println(xx.detectCapitalUse("USA"));
        System.out.println(xx.detectCapitalUse("FlaG"));
    }

    public boolean detectCapitalUse(String word) {
        return cond1(word)||cond2(word)||cond3(word);
    }

    private boolean cond1(String arg1){
        for (char x: arg1.toCharArray()){
            if (Character.isLowerCase(x)){
                return false;
            }
        }
        return true;
    }

    private boolean cond2(String arg2){
        for (char x: arg2.toCharArray()){
            if (Character.isUpperCase(x)){
                return false;
            }
        }
        return true;
    }

    private boolean cond3(String arg3){
        for (int i=0; i < arg3.length(); i ++){
            if ((i == 0) &&(Character.isLowerCase(arg3.charAt(i)))){
                return false;
            }
            if ((i != 0)&&(Character.isUpperCase(arg3.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}

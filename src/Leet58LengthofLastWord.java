/**
 * Created by liuxz on 17-3-19.
 */
public class Leet58LengthofLastWord {
    public int lengthOfLastWord(String s) {
        String[] output = s.split(" ");
        if (output.length == 0){
            return 0;
        }else{
            return output[output.length-1].length();
        }
    }

    public static void main(String[] args){
        Leet58LengthofLastWord xx = new Leet58LengthofLastWord();
        xx.lengthOfLastWord("Hello World");
    }
}

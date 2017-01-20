import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

/**
 * Created by liuxz on 17-1-19.
 */
public class Leet36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0 ; i < 9 ; i ++){
            int[] temp = new int[10];
            for (int j = 0 ; j < 9 ; j ++){
                if (Character.compare(board[i][j],'.') != 0){
                    int num = Character.getNumericValue(board[i][j]);
                    if (temp[num]>=1){
                        return false;
                    }else{
                        temp[num] ++;
                    }
                }
            }
        }

        for (int j = 0 ; j < 9 ; j ++){
            int[] temp = new int[10];
            for (int i = 0 ; i < 9 ; i ++){
                if (Character.compare(board[i][j],'.') != 0){
                    int num = Character.getNumericValue(board[i][j]);
                    if (temp[num]>=1){
                        return false;
                    }else{
                        temp[num] ++;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i = i+3){
            for (int j = 0; j < 9; j = j+3){
                int [] temp = new int[10];
                for (int ii = 0; ii < 3; ii ++){
                    for (int jj = 0; jj < 3; jj ++){
                        if (Character.compare(board[i+ii][j+jj],'.') != 0){
                            int num = Character.getNumericValue(board[i+ii][j+jj]);
                            if (temp[num]>=1){
                                return false;
                            }else{
                                temp[num]++;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }


    private char[][] change(String[] xx){
        char[][] x=new char[9][];
        for (int i =0 ; i < 9 ; i ++){
            x[i] = xx[i].toCharArray();
        }
        return x;
    }
    public static void main(String[] args){

        Leet36ValidSudoku abc = new Leet36ValidSudoku();
        String[] xx =  new String[]{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
        String[] yy =  new String[]{"..4...63.",".........","5......9.","...56....","4.3.....1","...7.....","...5.....",".........","........."};

        char[][] zz =abc.change(yy);
        for (int i = 0 ; i < 9 ; i ++){
            for (int j = 0 ; j < 9 ; j ++){
                System.out.print(zz[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(abc.isValidSudoku(abc.change(yy)));
    }
}

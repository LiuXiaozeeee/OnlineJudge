import java.util.Scanner;

/**
 * Created by Liuxz on 2017/8/25.
 */

/*
菜鸟仓库是一个很大很神奇的地方，各种琳琅满目的商品整整齐齐的放置在一排排货架上。
通常一种品类的商品会防止啊在货架的某一个格子中，格子设有统一的编号方便工人拣选。有
一天沐哲去菜鸟仓库参观，无意中发现第一个货架格子编码为1，第2-3个分别为1-2，第4-6
个别是1,2,3，第7-10个分别是1,2,3,4，每个格子编号都是0-9中的一个整数。且格子的编
号连在一起有如下规律。 1|12|123|1234|...|123456789101112131415|...|123456789101112131415...n
这个仓库存放的商品品类非常丰富，一共有1千万多个货架格子。沐哲很好奇，他想快速知道第k个格子编号是多少？

测试用例：
5
2

10
4

55
1

56
0
 */

public class Main2 {
    private int get(int n){
        int level = 1;
        int totalLength = 0;
        int currentNumber = 1;

        while(totalLength < n){
            if (currentNumber > level){
                level ++;
                currentNumber = 1;
            }
            totalLength += getLenght(currentNumber);
            currentNumber ++;
        }
        currentNumber --;
        return getcur(currentNumber, totalLength - n);
    }

    private int getLenght(int n){
        int result = 0;
        while (n != 0){
            n = n /10;
            result ++;
        }
        return result;
    }

    private int getcur(int n, int r){
        for (int i = 0; i < r ; i ++){
            n = n /10;
        }
        return n%10;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int _N;
        _N = in.nextInt();
        Main2 x = new Main2();
        System.out.println(x.get(_N));
    }
}

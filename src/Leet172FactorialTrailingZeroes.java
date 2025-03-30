public class Leet172FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int result = 0;
        for (int i = 1 ; i <= n; i ++){
            int z = i / 5;
            int r = i % 5;
            while(z > 0){
                if (r == 0){
                    result ++;
                    r = z % 5;
                    z = z / 5;
                }else{
                    break;
                }
            }
        }
        return result;
    }


    public int trailingZeroes2(int n){
        int base = 5;
        int result = 0;
        for (int i = 1; ; i ++){
            result = result + (n / base);
            base  = base * 5;
            if (base > n){
                break;
            }
        }
        return result;
    }


    public static  void main(String[] args){
        Leet172FactorialTrailingZeroes x = new Leet172FactorialTrailingZeroes();
        int result = x.trailingZeroes2(30);
        System.out.println(result);
    }
}

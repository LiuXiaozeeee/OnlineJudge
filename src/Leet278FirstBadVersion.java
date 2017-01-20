/**
 * Created by liuxz on 17-1-19.
 */
public class Leet278FirstBadVersion {
    public int firstBadVersion(int n){
        int begin= 0 , end = n;
        int mid = 0;
        while (begin < end - 1){
            mid = begin+(end-begin)/2;
            if (isBadVersion(mid)){
                end =mid;
            }else{
                begin=mid;
            }
        }
        if (isBadVersion(begin)){
            return begin;
        }else{
            return end;
        }
    }

    boolean isBadVersion(int version){
        return version >1702766719;
    }

    public static void main(String[] args){
        Leet278FirstBadVersion x = new Leet278FirstBadVersion();
        System.out.println(x.firstBadVersion(2126753390));
    }
}

/**
 * Created by Liuxz on 2017/8/18.
 */
public class Leet165CompareVersionNumbers {
    public static void main(String[] args){
        Leet165CompareVersionNumbers xx = new Leet165CompareVersionNumbers();
        System.out.println(
                xx.compareVersion("1.0.1","1")
        );
        System.out.println(
                xx.compareVersion("1.3","1.35")
        ); // 1.3 < 1.35
        System.out.println(
                xx.compareVersion("1.3412", "1.35")
        ); //  1.3412 > 1.35
        System.out.println(
                xx.compareVersion("1.3412", "1.3412")
        ); //  1.3412 == 1.3412
        System.out.println(
                xx.compareVersion("01", "1")
        ); //  1 == 1
        System.out.println(
                xx.compareVersion("01.0", "1.0")
        ); //  1 == 1
        System.out.println(
                xx.compareVersion("1", "1.0")
        ); //  1 == 1
    }

    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        int index  = 0;
        while (true){
            int status = checkLength(a1, a2, index);
            int x=4;
            if (status == 0){
                x = compareNumber(a1[index], a2[index]);
            }else if (status == 2){
                return 0;
            }else if (status == -1){
                x = compareNumber("0", a2[index]);
            }else if (status == 1){
                x = compareNumber(a1[index], "0");
            }
            if (x == 1){return 1;}
            else if (x == -1){return -1;}
            index ++;
        }
    }

    private int compareNumber(String a, String b){
        if (Integer.parseInt(a) > Integer.parseInt(b)){
            return 1;
        }else if (Integer.parseInt(a) < Integer.parseInt(b)){
            return -1;
        }else {
            return 0;
        }
    }

    private  int checkLength(String[] a1, String[] a2, int index){
        if ((a1.length > index)&&(a2.length > index)){
            return 0;
        }
        if ((a1.length <= index)&&(a2.length <= index)){
            return 2;
        }
        if ((a1.length <= index)&&(a2.length > index)){
            return -1;
        }
        if ((a1.length > index) && (a2.length <= index)){
            return 1;
        }
        else {
            return 4;
        }
    }
}

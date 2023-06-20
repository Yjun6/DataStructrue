/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-20
 * Time:20:43
 */

public class LK342 {
    public static boolean isPowerOfFour(int n) {
        if(n == 1){
            return true;
        }
        if(n < 4){
            return false;
        }
        return func(n);
    }

    public static boolean func(int n){
        if(n == 1){
            return true;
        }else if(n < 4){
            return false;
        }

        int tmp = n%4;//保存余数
        if(tmp != 0){
            return false;
        }

        return func(n/4);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(64));
    }
}
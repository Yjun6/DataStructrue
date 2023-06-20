/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-20
 * Time:20:53
 */

public class LK_326 {
    public boolean isPowerOfThree(int n) {
        if(n == 1){
            return true;
        }
        if(n<=0){
            return false;
        }
        return func(n);
    }

    public boolean func(int n){
        if(n == 1){
            return true;
        }else if(n < 3){
            return false;
        }

        int tmp = n%3;
        if(tmp != 0){
            return false;
        }

        return func(n/3);
    }
}

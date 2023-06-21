/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-21
 * Time:18:14
 */
public class LK509 {
    public int fib(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }

        return fib(n-1)+fib(n-2);
    }
}

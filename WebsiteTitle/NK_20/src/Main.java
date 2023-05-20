/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

//牛客编程题 旧键盘（20）
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            func(str1,str2);
        }
    }
    static void func(String s1,String s2){
        s1 = s1.toUpperCase();
        s2=s2.toUpperCase();
        Set<Character> set = new HashSet<>();
        for(char ch:s2.toCharArray()){
            set.add(ch);
        }
        for(char ch:s1.toCharArray()){
            if(!set.contains(ch)){
                //输出
                System.out.print(ch);
                //加载
                set.add(ch);
            }
        }
    }
}

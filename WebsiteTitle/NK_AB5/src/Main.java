/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<a.length();i++){
                if(!stack.empty()&&stack.peek()==a.charAt(i)){
                    stack.pop();
                }else{
                    stack.add(a.charAt(i));
                }
            }
            if(stack.empty()){
                System.out.println("0");
            }else{
                List<Character> list = new ArrayList<>();
                while(!stack.empty()){
                    list.add(stack.pop());
                }
                Collections.reverse(list);
                for(int i=0;i<list.size();i++){
                    System.out.print(list.get(i));
                }
            }
        }
    }
}

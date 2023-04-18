import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(isaa(ch)){
                stack.push(ch);
            }else{
                if(stack.empty()){
                    return false;
                }
                char tmp = stack.pop();
                if((tmp == '(' && ch == ')') ||
                        (tmp == '{' && ch == '}') ||
                        (tmp == '[' && ch == ']')){
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }
    public boolean isaa(char s){
        if(s == '(' || s == '{' || s == '[')
            return true;
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
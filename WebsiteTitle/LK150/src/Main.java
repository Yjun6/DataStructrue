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
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(!isa(tokens[i])){
                int tmp = Integer.valueOf(tokens[i]);
                stack.push(tmp);
            }else{
                int tmp1 = stack.pop();
                int tmp2 = stack.pop();
                switch(tokens[i]){
                    case "+":
                        stack.push(tmp2+tmp1);
                        break;
                    case "-":
                        stack.push(tmp2-tmp1);
                        break;
                    case "*":
                        stack.push(tmp2*tmp1);
                        break;
                    case "/":
                        stack.push(tmp2/tmp1);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public boolean isa(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
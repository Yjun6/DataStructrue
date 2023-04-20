import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
    //栈实现队列
class MyQueue {
    Stack<Integer> queue1;//入
    Stack<Integer> queue2;//出
    public MyQueue() {
        queue1 = new Stack<>();
        queue2 = new Stack<>();
    }

    public void push(int x) {
        queue1.push(x);
    }

    public int pop() {
        int x = 0;
        if(queue2.isEmpty()){
            while(!queue1.isEmpty()){
                queue2.push(queue1.pop());
            }
        }
        x = queue2.pop();
        return x;
    }

    public int peek() {
        int x = 0;
        if(queue2.isEmpty()){
            while(!queue1.isEmpty()){
                queue2.push(queue1.pop());
            }
        }
        x = queue2.peek();
        return x;
    }

    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
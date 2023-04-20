import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class MyStack {

    Queue<Integer> stack1;
    Queue<Integer> stack2;

    public MyStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();

    }

    public void push(int x) {
        if(!stack1.isEmpty()){
            stack1.offer(x);
        }else{
            stack2.offer(x);
        }
    }

    public int pop() {
        int x = 0;
        if(!stack1.isEmpty()){
            x = stack1.poll();
            while(!stack1.isEmpty()){
                stack2.offer(x);
                x = stack1.poll();
            }
        }else if(!stack2.isEmpty()){
            x = stack2.poll();
            while(!stack2.isEmpty()){
                stack1.offer(x);
                x = stack2.poll();
            }
        }
        return x;
    }

    public int top() {
        int x = 0;
        if(!stack1.isEmpty()){
            x = stack1.poll();
            while(!stack1.isEmpty()){
                stack2.offer(x);
                x = stack1.poll();
            }
            stack2.offer(x);
        }else if(!stack2.isEmpty()){
            x = stack2.poll();
            while(!stack2.isEmpty()){
                stack1.offer(x);
                x = stack2.poll();
            }
            stack1.offer(x);
        }
        return x;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
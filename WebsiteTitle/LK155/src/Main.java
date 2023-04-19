import java.util.*;

class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.add(val);
        if(stack2.isEmpty()){
            stack2.add(val);
        }else{
            if(stack2.peek() >= val){
                stack2.add(val);
            }
        }
    }

    public void pop() {
        int ret = stack1.pop();
        if(ret == stack2.peek()){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

}


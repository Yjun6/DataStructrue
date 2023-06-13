import demo.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-13
 * Time:15:32
 */
public class Stack {
    ListNode root;// 栈顶

    Stack(){
        root = new ListNode();
    }

    //入栈
    int push(int key){
        root.addFirst(key);
        return key;
    }

    //出栈
    int pop(){
        //空栈
        if(root.size() == 0){
            System.out.println("该栈为空栈，出栈失败");
            return -1;
        }
        //不是空栈
        int tmp = root.head.date;
        root.remove(root.head.date);
        return tmp;
    }

    //求栈顶元素
    int peek(){
        if(root.size() == 0){
            return -1;
        }
        return root.head.date;
    }

    //求长度
    int size(){
        return root.size();
    }

    //判断是否为空
    boolean empty(){
        return root.size() == 0;
    }

}

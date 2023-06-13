import demo.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-13
 * Time:15:41
 */
public class Queue {
    ListNode root;// 队列
    ListNode.Node end = root.end;//队尾
    ListNode.Node start = root.head;//队头

    Queue(){
        root = new ListNode();
    }

    //入队
    boolean offer(int tmp){
        root.addLast(tmp);
        return true;
    }

    //出队
    int poll(){
        //空队
        if(root.size() == 0){
            System.out.println("该队列为空队，出队失败");
            return -1;
        }
        //不是空队
        int tmp = root.head.date;
        root.remove(root.head.date);
        return tmp;
    }

    //求队头元素
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
    boolean isEmpty(){
        return root.size() == 0;
    }
}

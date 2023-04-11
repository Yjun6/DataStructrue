import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-10
 * Time:21:02
 */
// 1、无头单向非循环链表实现
public class SingleLinkedList {
    public class ListNode{
        int date;
        ListNode next;
    }
    //头结点
    ListNode head;
    //头插法
    public void addFirst(int data){
        ListNode l = new ListNode();
        l.date = data;
        if(head == null){
            head = l;
            return;
        }
        l.next = head;
        head = l;
    }
    //尾插法
    public void addLast(int data){
        ListNode l = new ListNode();
        l.date = data;
        //空链表
        if(head == null){
            head = l;
            return;
        }
        //插末尾
        ListNode tmp = returnIndex(size() - 1);
        tmp.next = l;
    }
    //根据下标返回链表地址
    private ListNode returnIndex(int index) {
        ListNode tmp = head;
        while(index > 0){
            tmp = tmp.next;
            index--;
        }
        return tmp;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
       if(index < 0 || index > size()){
           return false;
       }
       if(index == 0){
           addFirst(data);
           return true;
       }
       if(index == size()){
           addLast(data);
           return true;
       }
       //插入在中间
        ListNode l = new ListNode();
        l.date = data;
        ListNode tmp = returnIndex(index-1);
        l.next = tmp.next;
        tmp.next = l;
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        if(head == null){
            return false;
        }
        ListNode tmp = head;
        while(tmp != null){
            if(tmp.date == key){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(head == null){
            System.out.println("没找到要删除的数字："+key);
            return;
        }
        ListNode tmp = head;
        int index = 0;
        while(tmp != null){
            index++;
            if(tmp.date == key){
                break;
            }
            tmp = tmp.next;
        }
        //没找到
        if(tmp == null){
            System.out.println("没找到要删除的数字："+key);
            return;
        }
        //找到了
        //出当前循环时，index为tmp所在链表的当前个数（逻辑顺序）,所以要-1
        index--;
        //首
        if(index == 0){
            head = head.next;
            return;
        }
        //通过returnIndex找到需要删除的节点的前一个链表位置
        tmp = returnIndex(index - 1);
        //末
        if(index == size()-1){
            tmp.next = null;
            return;
        }
        //中间
        tmp.next = tmp.next.next;

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(head == null){
            System.out.println("没找到要删除的数字："+key);
            return;
        }

        ListNode tmp1 = head;
        //首
        while(tmp1 != null && tmp1.date == key){
            tmp1 = tmp1.next;
            head = tmp1;
        }
        if(tmp1 == null){
            System.out.println("没找到要删除的数字："+key);
            return;
        }
        //中间+末尾
        ListNode tmp2 = tmp1.next;
        while(tmp2 != null){
            if(tmp2.date == key){
                tmp1.next = tmp2.next;
            }else{
                tmp1 = tmp2;
            }
            tmp2 = tmp2.next;
        }
    }
    //得到单链表的长度
    public int size(){
        ListNode tmp = head;
        int num = 0;
        while(tmp != null){
            num++;
            tmp = tmp.next;
        }
        return num;
    }
    //打印链表
    public void display(){
        if(size() == 0){
            System.out.println("该链表中没有数值！");
            return;
        }
        ListNode tmp = head;
        for (int i = 0; i < size(); i++) {
            System.out.print(tmp.date+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    //清空链表
    public void clear(){
        //Java会自动回收无外部引用的内存
        head = null;
    }
}

class Main{
    public static void main(String[] args) {
        //创建一个链表
        SingleLinkedList list = new SingleLinkedList();
        SingleLinkedList.ListNode list1 = list.new ListNode();
        //测试用例
        list.addFirst(12);
        list.addFirst(14);
        list.addFirst(23);
        list.addFirst(54);
        list.addLast(25);
        list.addLast(25);
        list.addIndex(2,64);
        list.display();
        System.out.println(list.contains(45));
        System.out.println(list.contains(54));
        list.remove(10);
        list.remove(23);
        list.display();
        list.removeAllKey(54);
        list.removeAllKey(14);
        list.removeAllKey(25);
        list.display();

    }
}
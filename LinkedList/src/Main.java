/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
// 2、无头双向链表实现
class LinkedList {
    class ListNode {
        int val;
        ListNode pre = null;
        ListNode next = null;

        public ListNode() {
        }
        public ListNode(int val) {
            this.val = val;
        }
    }
    ListNode head;//头结点
    ListNode last;//尾结点
    //头插法
    public void addFirst(int data){
        ListNode tmp = new ListNode(data);
        if(head == null){
            head = tmp;
            last = tmp;
        }else{
            tmp.next = head;
            head.pre = tmp;
            head = tmp;
        }

    }
    //尾插法
    public void addLast(int data){
        ListNode tmp = new ListNode(data);
        if(last == null){
            head = tmp;
            last = tmp;
        }else{
            last.next = tmp;
            tmp.pre = last;
            last = tmp;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        if(index < 0 || index > size()){
            return false;
        }
        //插入头部
        if(index == 0){
            addFirst(data);
            return true;
        }
        //插入尾部
        if(index == size()){
            addLast(data);
            return true;
        }
        //插入中间结点
        ListNode tmp = new ListNode(data);
        ListNode scr = getListNode(index);
        scr.pre.next = tmp;
        tmp.pre = scr.pre;
        tmp.next = scr;
        scr.pre = tmp;
        return true;
    }
    //根据下标获取结点
    private ListNode getListNode(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("下标越界");
        }
        ListNode tmp = head;
        while(index-- > 0){
            tmp = tmp.next;
        }
        return tmp;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        if(head == null){
            return false;
        }
        ListNode tmp = head;
        while(tmp != null){
            if(tmp.val == key){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //空链表
        if(head == null){
            return;
        }
        //首结点
        if(head.val == key){
            head = head.next;
            head.pre = null;
            return;
        }
        //常规操作
        ListNode tmp = head.next;
        while(tmp != null && tmp.next != null){
            if(tmp.val == key){
                //删除结点
                tmp.pre.next = tmp.next;
                tmp.next.pre = tmp.pre;
                return;
            }
            tmp = tmp.next;
        }
        //末尾结点
        //不包含只有1个节点
        if(last.val == key){
            last = last.pre;
            last.next = null;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        //空链表
        if(head == null){
            return;
        }
        //首结点
        while(head != null && head.val == key){
            head = head.next;
            head.pre = null;
        }
        //常规操作
        ListNode tmp = head.next;
        while(tmp != null && tmp.next != null){
            if(tmp.val == key){
                //删除结点
                tmp.pre.next = tmp.next;
                tmp.next.pre = tmp.pre;
            }
            tmp = tmp.next;
        }
        //末尾结点
        //不包含只有1个节点
        if(last.val == key){
            last = last.pre;
            last.next = null;
        }
    }
    //得到单链表的长度
    public int size(){
        ListNode scr = head;
        int num = 0;
        while(scr != null){
            num++;
            scr = scr.next;
        }
        return num;
    }
    //打印链表
    public void display() {
        if(head == null){
            throw new IndexOutOfBoundsException("链表内无内容");
        }
        ListNode scr = head;
        while(scr != null){
            System.out.print(scr.val + " ");
            scr = scr.next;
        }
        System.out.println();
    }
    //清空链表
    public void clear(){
        if(head == null){
            return;
        }

        ListNode scr = head;
        while(scr != null){
            ListNode tmp = scr.next;
            scr.pre = null;
            scr.next = null;
            scr = tmp;
        }
        //头结点 尾结点置空
        head = null;
        last = null;
    }

}

//测试用例
public class Main{
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList();
        LinkedList.ListNode list = myLinkedList.new ListNode();
        myLinkedList.addFirst(34);
        myLinkedList.addFirst(78);
        myLinkedList.addFirst(24);
        myLinkedList.addFirst(26);
        myLinkedList.display();
        myLinkedList.clear();
        System.out.println("=============");
        myLinkedList.addLast(34);
        myLinkedList.addLast(34);
        myLinkedList.addLast(24);
        myLinkedList.addLast(26);
        myLinkedList.display();
        System.out.println("=============");
        myLinkedList.addIndex(0,34);
        myLinkedList.addIndex(1,45);
        myLinkedList.addIndex(6,34);
        myLinkedList.display();
        System.out.println(myLinkedList.contains(45));
        System.out.println(myLinkedList.contains(0));
        System.out.println("===========");
        myLinkedList.remove(45);
        myLinkedList.display();
        myLinkedList.removeAllKey(34);
        myLinkedList.display();
     }
}
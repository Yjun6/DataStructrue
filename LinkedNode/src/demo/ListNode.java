package demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-13
 * Time:15:15
 */
public class ListNode {
    public static class Node {
        public int date;
        public Node next;

        public Node() {
        }

        public Node(int date) {
            this.date = date;
        }

        public Node(int date, Node next) {
            this.date = date;
            this.next = next;
        }
    }

    public Node head;//头结点
    public Node end;//尾结点

    //头插法
    public void addFirst(int data){
        Node l = new Node();
        l.date = data;
        if(head == null){
            head = l;
            end = l;
            return;
        }
        l.next = head;
        head = l;

    }
    //尾插法
    public void addLast(int data){
        Node l = new Node();
        l.date = data;
        //空链表
        if(head == null){
            head = l;
            end = l;
            return;
        }
        //插末尾
        end.next = l;
        end = l;
//        Node tmp = returnIndex(size() - 1);
//        tmp.next = l;
    }
    //根据下标返回链表地址
    private Node returnIndex(int index) {
        Node tmp = head;
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
        Node l = new Node();
        l.date = data;
        Node tmp = returnIndex(index-1);
        l.next = tmp.next;
        tmp.next = l;
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        if(head == null){
            return false;
        }
        Node tmp = head;
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
        Node tmp = head;
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
            end = tmp;
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

        Node tmp1 = head;
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
        Node tmp2 = tmp1.next;
        while(tmp2 != null){
            if(tmp2.date == key){
                tmp1.next = tmp2.next;
            }else{
                tmp1 = tmp2;
            }
            tmp2 = tmp2.next;
        }

        end = tmp1;
    }
    //得到单链表的长度
    public int size(){
        Node tmp = head;
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
        Node tmp = head;
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
        end = null;
    }

    //修改
    public void revise(int key,int tmp){
        Node root = head;
        if(root == null){
            System.out.println("该链表为空，修改失败");
            return;
        }

        while(root != null){
            if(root.date == key){
                root.date = tmp;
                System.out.println("修改成功");
                return;
            }else{
                root = root.next;
            }
        }
        //没找到数据
        System.out.println("没有"+key+"这个数值，修改失败");
    }

    //逆转  end的指向未发生改变
    public Node reverseList() {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        Node scr = head.next;
        Node scrNext = scr.next;
        scr.next = head;
        head.next = null;
        head = scr;
        scr = scrNext;
        while(scr != null){
            scrNext = scr.next;
            scr.next = head;
            head = scr;
            scr = scrNext;
        }
        return head;
    }

    //排序 选择排序   end的指向未发生改变
    public void InlineSort(){
        Node root = head;
        while(root != null && root.next != null) {
            Node min = root;
            Node tmp = root;
            while (tmp != null) {
                if (tmp.date < min.date) {
                    min = tmp;
                }
                tmp = tmp.next;
            }
            //min和root交换
            int t = root.date;
            root.date = min.date;
            min.date = t;

            root = root.next;
        }
    }

    //合并两个有序链表   end的指向未发生改变
    public Node mergeTwoLists(Node list1, Node list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        Node head = new Node(0);
        Node tmp = head;
        while(list1 != null && list2 != null){
            if(list1.date < list2.date){
                tmp.next = list1;
                list1 = list1.next;
            }else{
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }

        if(list1 != null){
            tmp.next = list1;
        }
        if(list2 != null){
            tmp.next = list2;
        }
        return head.next;
    }
}



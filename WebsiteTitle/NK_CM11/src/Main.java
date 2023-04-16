/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode tmp1Head = new ListNode(0);
        ListNode tmp2Head = new ListNode(0);
        ListNode tmp1 = tmp1Head;
        ListNode tmp2 = tmp2Head;
        while(pHead != null){
            if(pHead.val < x){
                tmp1.next = pHead;
                tmp1 = tmp1.next;
            }else{
                tmp2.next = pHead;
                tmp2 = tmp2.next;
            }
            pHead = pHead.next;
        }
        tmp2.next = null;
        tmp1.next = tmp2Head.next;
        return tmp1Head.next;

    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
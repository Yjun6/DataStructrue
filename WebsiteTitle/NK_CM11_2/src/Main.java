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
        ListNode tmp = new ListNode(0);
        ListNode tmp1 = tmp;
        ListNode tmp2 = null;
        ListNode scr = pHead;
        while(scr != null){
            if(scr.val < x){
                tmp1.next = scr;
                tmp1 = tmp1.next;
            }else{
                if(tmp2 == null){
                    tmp2 = scr;
                    pHead = tmp2;
                }else{
                    tmp2.next = scr;
                    tmp2 = tmp2.next;
                }
            }
            scr = scr.next;
        }
        if(tmp2 != null){
            tmp2.next = null;
        }else{
            pHead = null;
        }
        tmp1.next = pHead;
        return tmp.next;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
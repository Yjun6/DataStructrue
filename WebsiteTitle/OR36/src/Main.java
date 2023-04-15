/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
//题解
public class Main {
    public boolean chkPalindrome(ListNode A) {
        // write code here
        if(A == null || A.next == null){
            return true;
        }
        ListNode flow = A;
        ListNode slow = A;
        //找到中间结点
        while(flow != null && flow.next != null){
            flow = flow.next.next;
            slow = slow.next;
        }
        //翻转链表
        //从slow 到 末尾开始翻转
        flow = slow.next;
        slow.next = null;
        while(flow != null){
            ListNode flowNext = flow.next;
            flow.next = slow;
            slow = flow;
            flow = flowNext;
        }
        //出循环时，slow指向翻转链表的末尾结点
        //头尾对比
        while(A != slow && A.next != slow){
            if(A.val != slow.val){
                return false;
            }
            A = A.next;
            slow = slow.next;
        }
        return true;
    }
}

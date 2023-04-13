/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null){
            return null;
        }
        if(k <= 0){
            return null;
        }
        ListNode flow = head;//快
        ListNode slow = head;//慢
        while(k-1 > 0 && flow != null){
            flow = flow.next;
            k--;
        }
        if(flow == null){
            return null;
        }
        while(flow.next != null){
            flow = flow.next;
            slow = slow.next;
        }

        return slow;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

//题解
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode flow = head;
        ListNode slow = head;
        while(flow != null && flow.next != null){
            flow = flow.next.next;
            slow = slow.next;
            if(flow == slow){
                return true;
            }
        }
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
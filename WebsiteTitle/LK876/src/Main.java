/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode flow = head;
        ListNode slow = head;
        while(flow != null && flow.next != null){
            flow = flow.next.next;
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
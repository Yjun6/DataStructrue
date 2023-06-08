/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-08
 * Time:20:13
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        func(head);
        return head;
    }
    void func(ListNode head){
        if(head == null || head.next==null){
            return;
        }

        while(head.val == head.next.val){
            head.next=head.next.next;
            if(head.next==null){
                break;
            }
        }

        func(head.next);
    }
}

public class main {


}

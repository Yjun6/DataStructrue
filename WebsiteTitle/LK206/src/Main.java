/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode scr = head.next;
        ListNode scrNext = scr.next;
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
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
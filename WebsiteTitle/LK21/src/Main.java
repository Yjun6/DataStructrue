/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
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
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
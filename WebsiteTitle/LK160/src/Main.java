/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */




public class Main{
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode tmp1 = headA;
        ListNode tmp2 = headB;
        while(tmp1 != null){
            len1++;
            tmp1 = tmp1.next;
        }
        while(tmp2 != null){
            len2++;
            tmp2 = tmp2.next;
        }
        int k = 0;
        if(len1 > len2){
            k = len1-len2;
            tmp1 = headA;//存储长链表
            tmp2 = headB;//存储短链表
        }else{
            k = len2 - len1;
            tmp2 = headA;
            tmp1 = headB;
        }
        for(int i = 0; i < k; i++){
            tmp1 = tmp1.next;
        }
        while(tmp1 != tmp2 && tmp1 != null && tmp2 != null){
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        if(tmp2 == null || tmp1 == null){
            return null;
        }
        return tmp1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(21);
        ListNode node2 = new ListNode(22);
        ListNode node3 = new ListNode(23);
        ListNode node4 = new ListNode(24);
        ListNode node5 = new ListNode(25);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node11 = new ListNode(212);
        ListNode node22 = new ListNode(222);
        node11.next = node22;
        node22.next = node3;

        getIntersectionNode(node1,node11);
    }
}

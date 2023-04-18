/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //空指针
        if(head == null){
            return null;
        }
        //判断是否有环
        ListNode tmp1 = head;
        ListNode tmp2 = head;
        while(tmp1 != null && tmp1.next != null){
            tmp1 = tmp1.next.next;
            tmp2 = tmp2.next;
            if(tmp1 == tmp2){
                //有环，跳出循环
                break;
            }
        }
        //没有环，结束程序
        if(tmp1 == null || tmp1.next == null){
            return null;
        }
        //有环，继续程序
        //1.中断环
        ListNode tmp = tmp1;
        tmp1 = tmp1.next;
        tmp2.next = null;
        //2.求长度
        tmp2 = tmp1;
        ListNode tmp3 = head;
        int len1 = 0, len2 = 0;
        while(tmp2 != null){
            tmp2=tmp2.next;
            len1++;
        }
        while(tmp3 != null){
            tmp3 = tmp3.next;
            len2++;
        }
        //k保存长度相差值
        //同时tmp2存长链表  tmp3存短链表
        int k = 0;
        if(len1 > len2){
            k = len1 - len2;
            tmp2 = tmp1;
            tmp3 = head;
        }else{
            k = len2 - len1;
            tmp2 = head;
            tmp3 = tmp1;
        }
        //3.求交点
        while(k > 0){
            k--;
            tmp2 = tmp2.next;
        }
        while(tmp2 != tmp3){
            tmp2 = tmp2.next;
            tmp3 = tmp3.next;
        }
        //把环合起来
        tmp.next = tmp1;
        //返回结果
        if(tmp2 == null || tmp3 == null){
            return null;
        }
        return tmp2;

    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode f,w;//快慢指针
        f = head;
        w = head;
        while(f != null && f.next != null){
            f = f.next.next;
            w = w.next;
        }
        while(w != null){
            stack.push(w.val);
            w = w.next;
        }

        while(!stack.empty()){
            if(stack.pop() != head.val){
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
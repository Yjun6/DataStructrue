
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node tmp = head;
        while(tmp != null){
            Node node = new Node(tmp.val);
            map.put(tmp,node);
            tmp = tmp.next;
        }

        tmp = head;
        while(tmp!=null){
            map.get(tmp).next = map.get(tmp.next);
            map.get(tmp).random = map.get(tmp.random);
            tmp = tmp.next;
        }

        return map.get(head);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
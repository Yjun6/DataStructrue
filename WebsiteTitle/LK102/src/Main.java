import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            List<Integer> list1 = new LinkedList<>();
            int size1 = queue.size();
            while(size1-- > 0){
                root = queue.poll();
                list1.add(root.val);
                if(root.left != null){
                    queue.offer(root.left);
                }
                if(root.right != null){
                    queue.offer(root.right);
                }
            }
            list.add(list1);
        }
        return list;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
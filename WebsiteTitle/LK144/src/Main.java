import javax.swing.tree.TreeNode;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = null;
        while(!stack.empty() || root!=null){
            while(root != null){
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
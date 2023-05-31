import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        func(root);
        return list;
    }

    List<Integer> list = new ArraysList<>();
    public void func(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        func(root.left);
        func(root.right);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
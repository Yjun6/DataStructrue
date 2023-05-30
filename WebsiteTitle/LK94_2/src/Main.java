/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        func(root);
        return list;
    }

    List<Integer> list = new ArrayList<>();
    public void func(TreeNode root){
        if(root == null){
            return;
        }
        func(root.left);
        list.add(root.val);
        func(root.right);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }


  }


public class Main{
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode tree1 = new TreeNode(2);
        TreeNode tree2 = new TreeNode(3);
        TreeNode tree3 = new TreeNode(4);
        tree.left = tree1;
        tree.right = tree2;
        tree1.right = tree3;
        inorderTraversal(tree);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.empty() || root!=null) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

}

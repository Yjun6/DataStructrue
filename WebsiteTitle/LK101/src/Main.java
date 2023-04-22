import javax.swing.tree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetricChild(root.left, root.right);
    }
    public boolean isSymmetricChild(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }

        return isSymmetricChild(left.left, right.right)
                && isSymmetricChild(left.right,right.left);
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
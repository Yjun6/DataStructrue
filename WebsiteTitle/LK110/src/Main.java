import javax.swing.tree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int len1 = isLen(root.left);
        int len2 = isLen(root.right);
        if(Math.abs(len1-len2) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int isLen(TreeNode root){
        if(root == null){
            return 0;
        }

        int len1 = isLen(root.left);
        int len2 = isLen(root.right);
        return (len1>len2?len1:len2)+1;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
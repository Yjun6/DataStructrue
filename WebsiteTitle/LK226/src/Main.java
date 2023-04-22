/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
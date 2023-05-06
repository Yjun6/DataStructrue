import javax.swing.tree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p==root || q==root){
            return root;
        }
        TreeNode a = lowestCommonAncestor(root.left,p,q);

        TreeNode b = lowestCommonAncestor(root.right,p,q);
        if(a != null && b != null){
            return root;
        }
        if(a != null){
            return a;
        }
        if(b != null){
            return b;
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
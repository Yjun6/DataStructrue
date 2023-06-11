/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-09
 * Time:16:42
 */
public class Solution {
    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }

        if(root.left==null){
            //右孩子不为空
            if(root.val >= root.right.val){
                return false;
            }
        }else if(root.right==null){
            //左孩子不为空
            if(root.val <= root.left.val){
                return false;
            }
        }else{
            //左右都不为空
            if(root.val >= root.right.val || root.val <= root.left.val ){
                return false;
            }
        }

        boolean f = isValidBST(root.left);
        if(f == false){
            return false;
        }
        return isValidBST(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(7);

        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;
        isValidBST(root);

    }
}

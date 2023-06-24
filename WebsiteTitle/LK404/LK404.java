/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) 
            return 0;

        if(root.left == null && root.right == null){
            return 0;
        }

        return func(root,root);
    }
    public int func(TreeNode root,TreeNode tmp){
        if(tmp == null) return 0;

        if(root.left == tmp){
            if(tmp.left == null && tmp.right == null){
                return tmp.val;
            }
        }
        
        int left1 = func(tmp,tmp.left);
        int right1 = func(tmp,tmp.right);
        return left1+right1;
        
    }
}
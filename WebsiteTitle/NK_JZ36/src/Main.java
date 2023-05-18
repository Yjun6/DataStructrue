import java.util.Stack;
/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        if(pRootOfTree.left==null && pRootOfTree.right==null){
            return pRootOfTree;
        }

        boolean ret = true;
        TreeNode tmp = null;
        TreeNode tmp1 = null;
        Stack<TreeNode> stack = new Stack<>();
        while(pRootOfTree != null || !stack.empty()){
            while(pRootOfTree != null){
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            pRootOfTree = stack.pop();
            if(ret){
                ret = false;
                tmp = pRootOfTree;
                tmp1 = tmp;
            }else{
                tmp1.right = pRootOfTree;
                pRootOfTree.left = tmp1;
                tmp1 = pRootOfTree;
            }
            pRootOfTree = pRootOfTree.right;
        }
        return tmp;
    }
}
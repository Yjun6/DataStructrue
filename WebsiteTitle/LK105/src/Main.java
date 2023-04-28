/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null){
            return null;
        }
        if(inorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        return buildTreeChild(preorder,inorder, 0, inorder.length-1);
    }

    int pre = 0;
    public TreeNode buildTreeChild(int[] preorder, int[] inorder, int form, int end){
        if(form > end) return null;
        if(pre >= preorder.length) return null;
        TreeNode tmp = new TreeNode(preorder[pre]);

        int i = findTree(inorder, preorder[pre],form,end);
        pre++;
        tmp.left = buildTreeChild(preorder,inorder, form, i-1);
        tmp.right = buildTreeChild(preorder,inorder, i+1, end);

        return tmp;
    }

    public int findTree(int[] inorder,int k, int index, int end) {
        for(int i = index; i<= end; i++){
            if(inorder[i] == k){
                return i;
            }
        }
        return -1;
    }
}
import javax.swing.tree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 1)
            return new TreeNode(inorder[0]);
        return buildTreeChild(inorder, postorder, 0, inorder.length-1, postorder.length-1);
    }

    int i = 0;
    public TreeNode buildTreeChild(int[] inorder, int[] postorder, int form, int end, int len){
        if(form > end) return null;
        if(i > len) return null;
        TreeNode tmp = new TreeNode(postorder[len-i]);

        int index = findTree(inorder, postorder[len-i],form,end);
        i++;
        tmp.right = buildTreeChild(inorder, postorder, index+1, end, len);
        tmp.left = buildTreeChild(inorder, postorder, form, index-1, len);

        return tmp;
    }

    public int findTree(int[] inorder, int key, int form, int end){
        for(int i = form; i <= end; i++){
            if(inorder[i] == key)
                return i;
        }
        return -1;
    }

}
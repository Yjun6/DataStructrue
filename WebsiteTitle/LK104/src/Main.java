/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-05-31
 * Time:22:35
 */
public class Main {
}

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left1 = maxDepth(root.left)+1;
        int right1 = maxDepth(root.right)+1;
        return left1>right1?left1:right1;
    }
}

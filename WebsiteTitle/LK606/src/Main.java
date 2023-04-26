import javax.swing.tree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Solution {
    public StringBuilder inTree(TreeNode root){
        if(root == null) return null;
        StringBuilder str = new StringBuilder();
        str.append(root.val);

        if(root.left != null){
            //左有  右有/没有
            str.append("(");
            str.append(inTree(root.left));
            str.append(")");
            if(root.right != null){
                str.append("(");
                str.append(inTree(root.right));
                str.append(")");
            }

        }else{
            //左没有 右有/没有
            if(root.right != null){
                str.append("()(");
                str.append(inTree(root.right));
                str.append(")");
            }
        }
        return str;
    }
    public String tree2str(TreeNode root) {
        StringBuilder str = inTree(root);
        return str.toString();
    }

}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String arr = in.nextLine();
            TreeNode tree = creatTree(arr);
            print(tree);
        }
    }

    public static void print(TreeNode tree){
        if(tree == null) return;
        print(tree.left);
        System.out.print(tree.val+" ");
        print(tree.right);
    }

    static int i = 0;
    public static TreeNode creatTree(String arr){
        TreeNode tree = null;
        char ch = arr.charAt(i);
        i++;
        if(ch != '#'){
            tree = new TreeNode(ch);
        }else{
            return null;
        }

        tree.left = creatTree(arr);
        tree.right = creatTree(arr);

        return tree;
    }

    public static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char val){
            this.val = val;
        }
        TreeNode(){ }
    }
}

}
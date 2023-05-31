package com.company;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class Main {
    public int sumNumbers(TreeNode root) {
        return func(root,0);
    }

    public int func(TreeNode root,int ret){
        if(root == null) return 0;
        int sum = ret*10+root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        return func(root.left,sum)+func(root.right,sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root.right = root2;
        System.out.println((new Main()).sumNumbers(root));
    }
}

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class BinaryTree {

    static class TreeNode {
        public char val;
        public TreeNode left;//左孩子的引用
        public TreeNode right;//右孩子的引用

        public TreeNode(char val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }


    /**
     * 创建一棵二叉树 返回这棵树的根节点
     *
     * @return
     */
    public TreeNode createTree() {
        TreeNode tree = new TreeNode('A');
        TreeNode tree1 = new TreeNode('B');
        TreeNode tree2 = new TreeNode('C');
        TreeNode tree3 = new TreeNode('D');
        TreeNode tree4 = new TreeNode('E');

        tree.left = tree1;
        tree1.left = tree3;
        tree.right = tree2;
        tree2.left = tree4;

        return tree;
    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    // 后序遍历
    void postOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        inOrder(root.right);
        System.out.print(root.val+" ");
    }

    public static int nodeSize = 0;
    /**
     * 获取树中节点的个数：遍历思路
     */
    void size(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode scr = null;//存放遍历的二叉树的上一次结点位置
        TreeNode tmp = null;//存放遍历的二叉树的这次结点位置
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
                nodeSize++;
            }
            scr = tmp;
            tmp = stack.peek();
            if(scr == tmp.right || tmp.right == null ){
                stack.pop();
            }else{
                root = tmp.right;
            }
        }
    }

    /**
     * 获取节点的个数：子问题的思路
     *
     * @param root
     * @return
     */
    int size2(TreeNode root) {
        if(root == null)
            return 0;
        return size2(root.left) + size2(root.right) + 1;
    }


    /*
     获取叶子节点的个数：遍历思路
     */
    public static int leafSize = 0;

    void getLeafNodeCount1(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafSize++;
            return;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
    }

    /*
     获取叶子节点的个数：子问题
     */
    int getLeafNodeCount2(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    /*
    获取第K层节点的个数
     */
    int getKLevelNodeCount(TreeNode root, int k) {
        if(k == 1 && root != null){
            return 1;
        }
        if(root == null || k < 1){
            return 0;
        }
        return getKLevelNodeCount(root.left, k-1) + getKLevelNodeCount(root.right, k - 1);
    }

    /*
     获取二叉树的高度
     时间复杂度：O(N)
     */
    int getHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        //左树长度
        int len1 = getHeight(root.left);
        //右树长度
        int len2 = getHeight(root.right);
        return (len1>len2?len1:len2) + 1;
    }


    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, char val) {
        if(root == null) {
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode ret = find(root.left,val);
        if(ret != null) {
            return ret;
        }
        ret = find(root.right,val);
        if(ret != null) {
            return ret;
        }
        return null;
    }


    //层序遍历
    void levelOrder(TreeNode root) {
        if(root == null){
            System.out.println("该树无结点");
            return;
        }
        //存储层序遍历的结果
        List<List<TreeNode>> list = new ArrayList<>();
        //存储每一次的结点
        Queue<TreeNode > queue = new LinkedList<>();

        while(!queue.isEmpty() || root != null){
            if(queue.isEmpty()){
                //处理根结点
                queue.add(root);
                List<TreeNode> list2 = new ArrayList<>();
                list2.add(root);
                list.add(list2);
                root = null;
            }
            List<TreeNode> list1 = new ArrayList<>();
            int size1 = queue.size();
            while(size1 > 0 ){
                size1--;
                TreeNode tmp = queue.poll();
                if(tmp.left != null){
                    queue.add(tmp.left);
                    list1.add(tmp.left);
                }
                if(tmp.right != null) {
                    queue.add(tmp.right);
                    list1.add(tmp.right);
                }
            }
            if(!list1.isEmpty()){
                list.add(list1);
            }
        }

        //输出层序遍历
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + "  ");
            }
            System.out.println();
        }
    }


    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(tmp == null){
                while(tmp == null && !queue.isEmpty()){
                    tmp = queue.poll();
                    if(tmp != null){
                        return false;
                    }
                }
            }else {
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode tree = binaryTree.createTree();
        System.out.println("+++++++++++前序遍历+++++++++++");
        binaryTree.preOrder(tree);
        System.out.println();
        System.out.println("+++++++++++中序遍历+++++++++++");
        binaryTree.inOrder(tree);
        System.out.println();
        System.out.println("+++++++++++后序遍历+++++++++++");
        binaryTree.postOrder(tree);
        System.out.println();
        System.out.println("+++++++++++二叉树结点个数+++++++++++");
        binaryTree.size(tree);
        System.out.println(nodeSize);
        System.out.println(binaryTree.size2(tree));
        System.out.println("++++++++++++++二叉树叶子结点个数++++++++++++++++");
        binaryTree.getLeafNodeCount1(tree);
        System.out.println(binaryTree.leafSize);
        System.out.println(binaryTree.getLeafNodeCount2(tree));
        System.out.println("+++++++++++++++求第二层结点个数+++++++++++++++");
        System.out.println(binaryTree.getKLevelNodeCount(tree, 2));
        System.out.println("+++++++++++++++++二叉树高度+++++++++++++++++");
        System.out.println(binaryTree.getHeight(tree));
        System.out.println("+++++++++++++++二叉树查找'A'++++++++++++");
        System.out.println(binaryTree.find(tree, 'A'));
        System.out.println("+++++++++++++++二叉树查找'N'++++++++++++");
        System.out.println(binaryTree.find(tree, 'N'));
        System.out.println("+++++++++++++++二叉树层序遍历输出++++++++++++");
        binaryTree.levelOrder(tree);
        System.out.println("+++++++++++++++二叉树是否为完全二叉树++++++++++++");
        System.out.println(binaryTree.isCompleteTree(tree));
    }
}
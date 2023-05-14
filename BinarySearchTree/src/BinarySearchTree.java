/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class BinarySearchTree {

    static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode root;

    /**
     * 插入一个元素
     * 不能插入二叉搜索树当中已有的数据，
     * 否则返回false
     * @param key
     */
    public boolean insert(int key) {
        if(root == null){
            root = new TreeNode(key);
            return true;
        }
        TreeNode p = root;
        TreeNode c = root;
        while(c != null){
            p = c;
            if(c.key < key){
                c = c.right;
            }else if(c.key > key){
                c = c.left;
            }else{
                return false;
            }
        }
        if(p.key < key){
            p.right = new TreeNode(key);
        }else{
            p.left = new TreeNode(key);
        }
        return true;
    }
    //查找key是否存在
    public TreeNode search(int key) {
        TreeNode tmp = root;
        while(tmp != null){
            if(tmp.key > key){
                tmp = tmp.left;
            }else if(tmp.key < key){
                tmp = tmp.right;
            }else{
                return tmp;
            }
        }
        return null;
    }
    //删除key的值
    public boolean remove(int key) {
        TreeNode tmp = root;
        TreeNode parent = root;//标记父母亲结点
        while(tmp != null){
            if(tmp.key > key){
                parent = tmp;
                tmp = tmp.left;
            }else if(tmp.key < key){
                parent = tmp;
                tmp = tmp.right;
            }else{
                break;
            }
        }
        if(tmp == null)
            return false;
        //删除操作
        //为左孩子
        if(tmp == parent.left){
            if(tmp.left == null){
                parent.left = tmp.right;
            }else if(tmp.right == null){
                parent.left = tmp.left;
            }else{
            //tmp左右孩子都不为空情况
                func(tmp);
            }
        } else if(tmp == parent.right){
            //右孩子
            if(tmp.left == null){
                parent.right = tmp.right;
            }else if(tmp.right == null){
                parent.right = tmp.left;
            }else {
                //tmp左右孩子都不为空情况
                func(tmp);
            }
        }else {
            //根节点
            if(root.left == null){
                root = root.right;
            }else if(root.right == null){
                root = root.left;
            }else{
                //tmp左右孩子都不为空情况
                func(root);
            }
        }
        return true;
    }

    public void func(TreeNode tmp){
        if(tmp == null) return;

        TreeNode ret = find(tmp);
        int key = ret.key;
        remove(ret.key);
        tmp.key = key;
    }
    //找到tmp结点右孩子的最左边
    public TreeNode find(TreeNode tmp){
        TreeNode tmp1 = tmp;
        tmp = tmp.right;
        while(tmp != null){
            tmp1 = tmp;
            tmp = tmp.left;
        }
        return tmp1;
    }

    public static void main(String[] args) {
        BinarySearchTree m = new BinarySearchTree();
        m.insert(6);
        m.insert(4);
        m.insert(5);
        m.insert(7);
        m.insert(8);
        m.insert(9);
        m.insert(3);
        TreeNode ret = m.search(4);
        System.out.println(ret.key);
        m.remove(4);

    }

}
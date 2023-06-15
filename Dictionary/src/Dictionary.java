import java.util.Comparator;

public class Dictionary extends DictionaryException implements Comparator<String> {

    static class TreeNode {
        public String key;//单词
        public String values;//存储单词的中文
        public TreeNode left;//左孩子
        public TreeNode right;//右孩子

        public TreeNode(String key,String values) {
            this.key = key;
            this.values = values;
        }

        public TreeNode(String key) {
            this.key = key;
        }
    }

    public TreeNode root;//根节点

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

    /**
     * 插入一个元素
     * 不能插入二叉搜索树当中已有的数据，
     * 否则返回false
     */
    public boolean insert(String key,String value){
        if(root == null){
            //树中无元素
            root = new TreeNode(key,value);
            return true;
        }
        //树中有元素
        TreeNode p = root;
        TreeNode c = root;
        while(c != null){
            p = c;
            if(c.key.compareTo(key) < 0){
                c = c.right;
            }else if(c.key.compareTo(key) > 0){
                c = c.left;
            }else{
                throw new DictionaryException("insert::"+key+"单词重复，插入失败");
            }
        }
        if(p.key.compareTo(key) < 0){
            p.right = new TreeNode(key,value);
        }else{
            p.left = new TreeNode(key,value);
        }
        return true;
    }

    //修改单词
    public boolean revise(String key,String tmp){
        TreeNode ret1 = search(key);
        if(ret1 == null){
            //单词不存在
            throw new DictionaryException("revise::单词不存在，修改失败");
        }else{
            //单词存在
            //搜索待添加单词是否存在
           TreeNode ret2 = search(tmp);
            if(ret2==null){
                //删除
                remove(key);
                //增加
                insert(tmp,ret1.values);
            }else{
                //已有元素
                throw new DictionaryException("revise::修改后的单词已存在，修改失败");
            }

            return true;
        }
    }

    //查找
    public TreeNode search(String key) {
        TreeNode tmp = root;
        while(tmp != null){
            if(tmp.key.compareTo(key) > 0){
                tmp = tmp.left;
            }else if(tmp.key.compareTo(key) < 0){
                tmp = tmp.right;
            }else{
                return tmp;
            }
        }
        return null;
    }

    //删除
    public boolean remove(String key) {
        TreeNode tmp = root;
        TreeNode parent = root;//标记父母亲结点
        while(tmp != null){
            if(tmp.key.compareTo(key) > 0){
                parent = tmp;
                tmp = tmp.left;
            }else if(tmp.key.compareTo(key) < 0){
                parent = tmp;
                tmp = tmp.right;
            }else{
                break;
            }
        }
        if(tmp == null) {
            System.out.println(key+"不存在，删除失败");
            return false;
        }
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
    private void func(TreeNode tmp){
        if(tmp == null) return;

        TreeNode ret = find(tmp);
        String key = ret.key;
        remove(ret.key);
        tmp.key = key;
    }
    //找到tmp结点右孩子的最左边
    private TreeNode find(TreeNode tmp){
        TreeNode tmp1 = tmp;
        tmp = tmp.right;
        while(tmp != null){
            tmp1 = tmp;
            tmp = tmp.left;
        }
        return tmp1;
    }

    //前序遍历的形式输出
    public void order(){
        order1(root);
    }
    private void order1(TreeNode root){
        if(root == null) return;
        System.out.print(root.key+"  "+root.values+'\n');
        order1(root.left);
        order1(root.right);
    }

    //以中序遍历的形式输出
    public void inorder(){
        inorder1(root);
    }
    private void inorder1(TreeNode root){
        if(root == null) return;
        inorder1(root.left);
        System.out.print(root.key+"  "+root.values+'\n');
        inorder1(root.right);
    }

    //以后序遍历的形式输出
    public void reorder(){
        reorder1(root);
    }
    private void reorder1(TreeNode root){
        if(root == null) return;
        reorder1(root.left);
        reorder1(root.right);
        System.out.print(root.key+"  "+root.values+'\n');
    }

    //初始化词典
    public void init(Dictionary dictionary) {
        dictionary.insert("word","单词");
        dictionary.insert("insert","添加");
        dictionary.insert("day","日子");
        dictionary.insert("copy","复制");
        dictionary.insert("static","静态");
        dictionary.insert("find","寻找");
        dictionary.insert("add","添加");
        dictionary.insert("dictionary","词典");
        dictionary.insert("choice","机会");
        dictionary.insert("play","玩耍");
        dictionary.insert("public","公开的");
        dictionary.insert("private","私有的");
        dictionary.insert("protected","保护的");
    }

}



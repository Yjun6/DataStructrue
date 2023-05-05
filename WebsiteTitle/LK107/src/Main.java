/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> list1 = new LinkedList<>();
            while(len-- > 0){
                root = queue.poll();
                list1.add(root.val);
                if(root.left != null){
                    queue.offer(root.left);
                }
                if(root.right != null){
                    queue.offer(root.right);
                }
            }
            list.add(list1);
        }

        int leftList = 0;
        int rightList = list.size()-1;
        while(leftList < rightList){
            List<Integer> tmp = list.get(leftList);
            list.set(leftList, list.get(rightList));
            list.set(rightList, tmp);
            leftList++;
            rightList--;
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
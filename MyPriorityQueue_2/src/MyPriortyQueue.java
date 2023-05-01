import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class PriorityException extends RuntimeException{
    public PriorityException(String s){
        super(s);
    }
}


public class MyPriortyQueue implements Comparator<Integer> {
    public int[] elem;
    public int usedSize;

    public MyPriortyQueue(int k) {
        elem = new int[k];
    }

    public MyPriortyQueue() {
        elem = new int[11];
    }

    @Override
    public int compare(Integer o1,Integer o2) {
        return o2.compareTo(o1);
    }

    /**
     * 建堆的时间复杂度：
     *
     * @param array
     */
    public void createHeap(int[] array) {
        for(int i = 0; i < array.length; i++){
            elem[i] = array[i];
            usedSize++;
        }
        for(int i = (usedSize-1-1)/2; i >= 0; i--){
            shiftDown(i,usedSize-1);
        }
    }

    /**
     * 向下调整
     * @param root 是每棵子树的根节点的下标
     * @param len  是每棵子树调整结束的结束条件
     * 向下调整的时间复杂度：O(logn)
     */
    private void shiftDown(int root,int len) {
        int child = root*2+1;
        while(child < len){
            if(child+1<len && compare(elem[child],elem[child+1])>0){
                child++;
            }
            if(compare(elem[root],elem[child])>0){
                int tmp = elem[root];
                elem[root] = elem[child];
                elem[child] = tmp;
                root = child;
                child = root*2+1;
            }else{
                break;
            }
        }
    }


    /**
     * 入队：仍然要保持是大根堆
     * @param val
     */
    public void push(int val) {
        if(isEmpty()){
            elem[0] = val;
        }else{
            elem[usedSize] = val;
        }
        usedSize++;
        shiftUp(usedSize-1);
    }
    /**
     * 向上调整
     * 默认除了需要调整的地方外，其余都是已经调整好了的
     */
    private void shiftUp(int child) {
        int parent = (child-1)/2;
        while(child > 0){
            if(compare(elem[parent],elem[child])>0){
                int tmp = elem[parent];
                elem[parent] = elem[child];
                elem[child] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    /**
     * 出队【删除】：每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public void pollHeap() throws PriorityException{
        if(isEmpty()){
            throw new PriorityException("pollHeap::队列无元素，删除失败");
        }
        elem[0] = elem[usedSize-1];
        usedSize--;
        shiftDown(0, usedSize-1);
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int peekHeap() throws PriorityException{
        if(isEmpty()){
            throw new PriorityException("peekEmpty::队列无元素，获取失败");
        }
        return elem[0];
    }

    public static void main(String[] args) {
        MyPriortyQueue p = new MyPriortyQueue();
        int[] arr = {2,4,2,5,7,9,5,3};
        p.createHeap(arr);
        System.out.println("+=========创建一个堆========+");
        System.out.println(Arrays.toString(p.elem));
        p.push(10);
        System.out.println("+=========入一个值========+");
        System.out.println(Arrays.toString(p.elem));
        System.out.println("+=========输出堆顶========+");
        System.out.println(p.peekHeap());
        p.pollHeap();
        System.out.println("+=========删除堆顶=======+");
        System.out.println(Arrays.toString(p.elem));
    }
}
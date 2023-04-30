import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class PriorityException extends RuntimeException {
    PriorityException(String s){
        super(s);
    }
}

public class PriorityQueue implements Comparator<Integer> {
    public int[] elem;
    public int usedSize;
    private static int MAX = 11;

    public PriorityQueue() {
        this.elem = new int[MAX];
        this.usedSize = 0;
    }

    public PriorityQueue(int k) {
        this.elem = new int[k];
        MAX = k;
        this.usedSize = 0;
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
        for(int i = 0; i < array.length;i++){
            elem[i] = array[i];
            usedSize++;
        }
        for(int parent = (usedSize-1-1)/2; parent>=0;parent--){
            shiftDown(parent,usedSize);
        }
    }

    /**
     *向下调整
     * @param root 是每棵子树的根节点的下标
     * @param len  是每棵子树调整结束的结束条件
     * 向下调整的时间复杂度：O(logn)
     */
    private void shiftDown(int root,int len) {
        int child = root*2+1;
        while(child<len){
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
        if(isFull()){
            elem = cloneArray(elem);
        }
        elem[usedSize++] = val;
        shiftUp(usedSize-1);
    }


    //向上调整
    private void shiftUp(int child) {
        int parent = (child-1)/2;
        while(child>0){
            if(compare(elem[parent],elem[child])>0){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }

//    判断是否满容
    public boolean isFull() {
        return usedSize == MAX;
    }

    //扩容
    private int[] cloneArray(int[] arr){
        arr = Arrays.copyOf(arr,arr.length*2);
        MAX = arr.length*2;
        return arr;
    }
    /**
     * 出队【删除】：每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public void pollHeap() {
        if(usedSize == 0){
            throw new PriorityException("队列无元素，抛出异常");
        }
        elem[0] = elem[usedSize-1];
        usedSize--;
        shiftDown(0,usedSize-1);
    }

    public boolean isEmpty() {
        return 0 == usedSize;
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int peekHeap() throws PriorityException{
        if(usedSize == 0){
            throw new PriorityException("peekHeap::无元素，获取失败");
        }
        return elem[0];
    }


    public static void main(String[] args) {
        int[] arr = {1,4,5,6,7,3,2,1,0};
        PriorityQueue p = new PriorityQueue(arr.length);
        p.createHeap(arr);
        System.out.println(Arrays.toString(p.elem));
        System.out.println("+++++++++++++");
        System.out.println(p.peekHeap());
        p.push(5);
        System.out.println(Arrays.toString(p.elem));
    }
}
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
class Solution {
    public int[] smallestK(int[] arr, int k) {
        if(arr == null || k == 0) return new int[k];
        Comp comp = new Comp();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comp);//求大根堆
        for(int i = 0; i < k; i++){
            priorityQueue.offer(arr[i]);
        }
        for(int i = k; i < arr.length; i++){
            if(arr[i] < priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        int[] str = new int[priorityQueue.size()];
        for(int i = 0; i < str.length; i++){
            str[i] = priorityQueue.poll();
        }
        return str;
    }
}


class Comp implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b){
        return b.compareTo(a);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
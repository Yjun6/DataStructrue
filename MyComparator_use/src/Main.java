import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Comp implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b){
        return b.compareTo(a);
    }
}
public class Main {
    public static int[] findMinK(int[] str, int k){
        Comp comp = new Comp();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comp);//求大根堆
        for(int i = 0; i < k; i++){
            priorityQueue.offer(str[i]);
        }
        for(int i = k; i < str.length; i++){
            if(str[i] < priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(str[i]);
            }
        }
        int[] arr = new int[priorityQueue.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = priorityQueue.poll();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,5,6,7,3,4,1};
        int[] str = findMinK(arr,3);
        System.out.println(Arrays.toString(str));
    }
}
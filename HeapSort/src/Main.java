import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    //堆排序
    public static void heapSort(int[] arr){
        //使arr成为大根堆
        int len = arr.length;
        for (int i = (len-1-1)/2; i >= 0; i--) {
            shiftDown(arr, i, len-1);
        }
        while(len > 0){
            //将堆顶与堆末尾交换
            swap(arr,0,len-1);
            len--;
            shiftDown(arr,0,len-1);
        }
    }
    //向下调整
    public static void shiftDown(int[] arr, int parent, int k){
        int child = parent*2+1;
        while(child <= k){
            if(child+1<=k && arr[child+1]>arr[child]){
                child++;
            }
            if(arr[child] > arr[parent]){
                swap(arr,parent,child);
                parent = child;
                child = parent*2+1;
            }else{
                break;
            }
        }
    }
    //交换
    public static void swap(int[] arr, int s1, int s2){
        int tmp = arr[s1];
        arr[s1] = arr[s2];
        arr[s2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {100,34,12,56,23,67,24,8,2,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
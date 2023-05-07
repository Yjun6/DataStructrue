import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    //冒泡排序
    public static void bubbleSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            boolean ret = true;
            for (int j = 0; j < len-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    ret = false;
                }
            }
            if(ret == true){
                break;
            }
        }
    }
    public static void swap(int[] arr, int s1, int s2){
        int tmp = arr[s1];
        arr[s1] = arr[s2];
        arr[s2] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = {10,5,6,1,4,9,7,3,8,0,2,0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
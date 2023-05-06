import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    //选择排序优化
    public static void selectSort(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int min = left;
            int max = right;
            for (int i = left; i <= right; i++) {
                if(arr[i] < arr[min]){
                    min = i;
                }
                if(arr[i] > arr[max]){
                    max = i;
                }
            }
            //交换
            swap(arr,min,left);
            if(left == max){
                max = min;
            }
            swap(arr,max,right);
            left++;
            right--;
        }
    }
    //交换
    public static void swap(int[] arr, int s1, int s2) {
        int tmp = arr[s1];
        arr[s1] = arr[s2];
        arr[s2] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = {100,34,12,45,21,4,23,56,24,0};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
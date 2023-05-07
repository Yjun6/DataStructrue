import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    //快速排序 Hoare法
    public static void quickSort(int[] arr){
        quickSortFunc2(arr,0,arr.length-1);
    }
    //基准 左右不断递归
    public static void quickSortFunc2(int[] arr, int left, int right){
        //出递归条件
        if(left >= right) return;
        //基准下标
        int index = quickSortFunc1(arr,left,right);
        quickSortFunc2(arr,left,index-1);
        quickSortFunc2(arr,index+1,right);
    }

    //找基准，划分基准左右
    public static int quickSortFunc1(int[] arr, int left, int right){
        int tmp = arr[left];
        int i = left;
        while (left < right){
            while(left < right && arr[right] >= tmp){
                right--;
            }
            while(left < right && arr[left] <= tmp){
                left++;
            }
            swap(arr,left,right);
        }
        swap(arr,i,left);
        return left;
    }
    //交换
    public static void swap(int[] arr, int s1, int s2){
        int tmp = arr[s1];
        arr[s1] = arr[s2];
        arr[s2] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = {100, 23, 56, 34, 45, 23, 0};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
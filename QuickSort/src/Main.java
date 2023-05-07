import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    //快速排序 挖坑法
    public static void quickSort(int[] arr){
        quickSortFunc2(arr,0,arr.length-1);
    }
    //基准 左右不断递归
    public static void quickSortFunc2(int[] arr, int left, int right){
        //出递归条件
        if(left >= right) return;
        //优化 当left right中间数字较少时，进行直插
        if(right-left+1 <= 7){
            insertSort(arr,left,right);
            return;
        }
        //基准下标
        int index = quickSortFunc1(arr,left,right);
        quickSortFunc2(arr,left,index-1);
        quickSortFunc2(arr,index+1,right);
    }
    //直插
    public static void insertSort(int[] arr,int left1, int right1){
        for (int i = left1+1; i <= right1; i++) {
            int tmp = arr[i];
            //最左边下标
            int left = 0;
            //最右边下标
            int right = i-1;
            while(left <= right){
                int mid = (left+right)/2;
                if(tmp < arr[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            for (int j = i-1; j >= right+1; j--) {
                arr[j+1] = arr[j];
            }
            arr[right+1] = tmp;
        }
    }
    //找基准，划分基准左右
    public static int quickSortFunc1(int[] arr, int left, int right){
        int mid = (left+right)/2;
        int index = mid;
        if(arr[left] < arr[right]){
            if(arr[mid] < arr[left]){
                index = left;
            }else if(arr[mid] > arr[right]){
                index = right;
            }
        }else{
            if(arr[mid] < arr[right]){
                index = right;
            }else if(arr[mid] > arr[left]){
                index = left;
            }
        }
        swap(arr,index,left);
        int tmp = arr[left];
        while (left < right){
            while(left < right && arr[right] >= tmp){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= tmp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
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
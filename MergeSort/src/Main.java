import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    //递归
    public static void mergeSort(int[] arr){
        mergeSortFunc1(arr,0,arr.length-1);
    }

    //合并
    public static void mergeSortFunc1(int[] arr, int left,int right){
        if(left>=right) return;
        int mid = (right+left)/2;
        mergeSortFunc1(arr,left,mid);
        mergeSortFunc1(arr,mid+1,right);
        mergeSortFunc2(arr,left,mid,right);
    }
    //插入
    public static void mergeSortFunc2(int[] arr,int left, int mid, int right){
        int[] arr1 = new int[right-left+1];
        int i = 0;
        int tmp =left;
        int left2 = mid+1;
        while(left<=mid && left2<=right){
            if(arr[left] < arr[left2]){
                arr1[i++] = arr[left++];
            }else{
                arr1[i++] = arr[left2++];
            }
        }
        while(left<=mid){
            arr1[i++] = arr[left++];
        }
        while(left2<=right){
            arr1[i++] = arr[left2++];
        }

        for (int j = 0; j < i; j++) {
            arr[tmp+j] = arr1[j];
        }
    }

    //非递归
    public static void mergeSort1(int[] arr){
        int gap = 1;
        while(gap<arr.length){
            for (int i = 0; i < arr.length; i+=gap*2) {
                int right = i+gap*2-1;
                if(right>=arr.length){
                    right = arr.length-1;
                }
                int mid = i+gap-1;
                if(mid>=arr.length){
                    mid = arr.length-1;
                }
                mergeSortFunc2(arr,i,mid,right);
            }
            gap*=2;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,0,45,23,12,34,0,0,1,2,3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {2,0,45,23,12,34,0,0,1,2,3};
        mergeSort1(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
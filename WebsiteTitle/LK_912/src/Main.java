import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */


public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int[] arr = {5,1,1,2,0,0};
        m.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }

    public static void mergeSort(int[] arr){
        int gap = 1;
        while (gap<arr.length){
            for (int i = 0; i < arr.length; i+=gap*2) {
                int right = i+gap*2-1;
                if(right >= arr.length){
                    right=arr.length-1;
                }
                int mid = i+gap-1;
                if(mid >= arr.length){
                    mid = arr.length-1;
                }
                merge(arr,i,mid,right);
            }
            gap *= 2;
        }
    }

    public static void merge(int[] arr,int left, int mid, int right){
        int[] arr2 = new int[right-left+1];

       int left2 = mid+1;
       int k =0 ;
       int tmp = left;
       while(left <= mid && left2 <= right){
           if(arr[left] < arr[left2]){
               arr2[k++] = arr[left++];
           }else{
               arr2[k++] = arr[left2++];
           }
       }
       while(left <= mid){
           arr2[k++] = arr[left++];
       }
       while(left2 <= right){
           arr2[k++] = arr[left2++];
       }
        for (int i = 0; i < k; i++) {
            arr[tmp+i] = arr2[i];
        }
    }
}

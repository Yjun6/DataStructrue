import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    //直插的优化-》折半查找
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
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

    public static void main(String[] args) {
        int[] arr = {0,2,1,3,5,2,1,4,0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
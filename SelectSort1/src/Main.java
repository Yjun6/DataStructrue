import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    //选择排序
    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length-1;i++){
            int min = i;
            for(int j = i+1; j < arr.length;j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,42,11,23,7,45,23};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
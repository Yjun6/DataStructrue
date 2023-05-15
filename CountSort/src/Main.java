import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void CountSort(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min){
                min=arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int[] arr1 = new int[max-min+1];

        for (int i = 0; i < arr.length; i++) {
            arr1[arr[i]-min]++;
        }
        int k = 0;
        for (int i = 0; i < arr1.length; i++) {
            while(arr1[i]-- > 0){
                arr[k++] = min+i;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {100,23,14,57,23,13,36,58,10};
        CountSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    //直插
    public static void InlineSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]){
                int tmp = arr[i];
                int j = i-1;
                for (; j >= 0; j--) {
                    if(arr[j]>tmp){
                        arr[j+1] = arr[j];
                    }else{
                        break;
                    }
                }
                arr[j+1] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[] a1 = {2,5,7,2,3,0,6,5,1,4};
        InlineSort(a1);
        System.out.println(Arrays.toString(a1));
    }
}
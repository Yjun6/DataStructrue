import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    //希尔排序
    public static void shellSort(int[] arr){
        int len = arr.length;
        int d = len/2;//组数，数据之间的间距
        while(d >= 1){
            for(int i = 0; i < d; i++){
                for (int j = i+d; j < len; j+=d) {
                    int tmp = arr[j];
                    int k = j-d;
                    for (; k >= 0; k-=d) {
                        if(tmp < arr[k]){
                            arr[k+d] = arr[k];
                        }else{
                            break;
                        }
                    }
                    arr[k+d] = tmp;
                }
            }
            d /= 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,4,2,14,7,9,5,0,4,2};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
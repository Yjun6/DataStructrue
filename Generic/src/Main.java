/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class MyArray <T extends Comparable<T>>{
        public Object[] array = new Object[10];

    public void setArray(int index, T m) throws IndexOutOfBoundsException {
        if(index < 0 || index >= array.length){
            new IndexOutOfBoundsException("数组越界");
        }
        array[index] = m;
    }

    public T getArray(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= array.length){
            new IndexOutOfBoundsException("数组越界");
        }
        return (T)array[index];
    }
    public T maxArray(T[] array){
        T max = array[0];
        for(int i = 1; i < array.length; i++){
            if(max.compareTo(array[i])<0){
                max = array[i];
            }
        }
        return max;
    }
}

class ArrayFindMax{
    public static<T extends Comparable<T>> T findMax(T[] array){
        T max = array[0];
        for(int i = 1; i < array.length; i++){
            if(max.compareTo(array[i])<0){
                max = array[i];
            }
        }
        return max;
    }
}
public class Main {
    public static void main(String[] args) {
        Integer[] arr = {34,53,23,56,78,24};
        System.out.println(ArrayFindMax.<Integer>findMax(arr));
    }

    public static void main1(String[] args) {
        MyArray<Integer> myArray = new MyArray<>();
        myArray.setArray(0,3);
        myArray.setArray(1,2);
        myArray.setArray(2,4);
        Integer[] arr = {1,3,4,2,5,7,0,9,6};
        Integer max = myArray.maxArray(arr);
        System.out.println(max);
    }
}
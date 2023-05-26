/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class MyCircularDeque {

    int start = 0;
    int end = 0;
    int size = 0;//表示最大容量
    int[] elem;
    public MyCircularDeque(int k) {
        elem = new int[k+1];
        size = k+1;
    }

    public boolean insertFront(int value) {
        if((end+1)%size == start){
            //满了
            return false;
        }
        start = (start-1+size)%size;
        elem[start] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if((end+1)%size == start){
            //满了
            return false;
        }
        elem[end] = value;
        end = (end+1)%size;
        return true;
    }

    public boolean deleteFront() {
        if(start == end){
            return false;
        }
        start = (start+1)%size;
        return true;
    }

    public boolean deleteLast() {
        if(start == end){
            return false;
        }
        end = (end-1+size)%size;
        return true;
    }

    public int getFront() {
        if(start == end){
            return -1;
        }
        return elem[start];
    }

    public int getRear() {
        if(start == end){
            return -1;
        }
        return elem[(end-1+size)%size];
    }

    public boolean isEmpty() {
        return start==end;
    }

    public boolean isFull() {
        return (end+1)%size == start;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
class MyCircularQueue {

    int[] element;
    int head;
    int last;
    int MAX;
    public MyCircularQueue(int k) {
        element = new int[k + 1];
        MAX = k+1;
        head = 0;
        last = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            element[0] = value;
            head = 0;
            last = 1;
            return true;
        }
        element[last] = value;
        last = (last+1)%MAX;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head = (head+1)%MAX;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return element[head];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return element[(last-1+MAX)%MAX];
    }

    public boolean isEmpty() {
        return last == head;
    }

    public boolean isFull() {
        return (last+1) % MAX == head;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
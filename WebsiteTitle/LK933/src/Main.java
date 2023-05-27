import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    Queue<Integer> min;
    public RecentCounter() {
        min = new LinkedList<>();
    }

    public int ping(int t) {
        min.offer(t);
        int start = t-3000;
        while(min.peek()<start){
            min.poll();
        }
        return min.size();
    }
}

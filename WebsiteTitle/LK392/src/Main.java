import java.util.*;


public class Main {

    public boolean isSubsequence (String S, String T) {

        char[] str = T.toCharArray();//父母
        char[] str2 = S.toCharArray();

        Queue<Character> queue1 = new LinkedList<>();
        Queue<Character> queue2 = new LinkedList<>();
        for(int i=0;i<str.length;i++){
            queue1.offer(str[i]);
        }
        for(int i=0;i<str2.length;i++){
            queue2.offer(str2[i]);
        }
        while(!queue1.isEmpty()&&!queue2.isEmpty()){
            char tmp1=queue1.poll();
            if(tmp1 == queue2.peek()){
                queue2.poll();
            }
        }
        return queue2.isEmpty();

    }
}